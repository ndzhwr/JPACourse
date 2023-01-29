package me.rexisn.JPACourse;
import java.util.List;
import javax.persistence.*;

public class TestSystem {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JPACourse");
    public static void main(String[] args) {

       createCustomer(new Customer("ndizihiweregis06@gmail.com","NDIZIHIWE", "Regis"));
       createCustomer(new Customer("mwenedata@gmail.com","Mwenedata", "Apotre"));
       createCustomer(new Customer("mutesacedric@gmail.com","Mutesa", "Cedric"));

        List<Customer> customers = getCustomers();
        customers.forEach(customer -> System.out.printf("%n |  %s -- %s -- %s -- %s", customer.getCustId(),customer.getEmail(), customer.getFname(), customer.getLfname()));
        System.out.print("\n\n------------------------ ");

        Customer custwithid1  =  getSingleCustomer(1);
        System.out.printf("%n | %s -- %s -- %s -- %s", custwithid1.getCustId() , custwithid1.getFname() , custwithid1.getLfname() , custwithid1.getEmail());
        System.out.print("\n\n------------------------ ");

        Customer updatedRegis  = updateCustomerEmailById(1,"ndiregis2006@gmail.com");
        Customer deleteApotre  = deleteCustomerById(2);

        ENTITY_MANAGER_FACTORY.close();
    }

    public static void createCustomer(Customer customer) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            em.persist(customer);
            et.commit();
        } catch (Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static List<Customer> getCustomers() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        List<Customer> customers = null;
        try {
            et = em.getTransaction();
            et.begin();
            TypedQuery<Customer> query =  em.createQuery("SELECT c FROM Customer c WHERE c.custId IS NOT NULL", Customer.class);
            customers  = query.getResultList();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        catch (Exception e) {
            if(et != null)  et.rollback();
            e.printStackTrace();

        }finally {
            em.close();
        }
        return customers;
    }

    public static Customer getSingleCustomer(int custId) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Customer customer = null;
        try {
            et = em.getTransaction();
            et.begin();
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.custId = :custId", Customer.class);
            customer = query.setParameter("custId", custId).getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            if (et != null) et.rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return customer;
    }

    public static  Customer updateCustomerEmailById(int id,String email) {
        EntityManager em  = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Customer customer = null ;
        try {
            et = em.getTransaction();
            et.begin();
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.custId = :custId",Customer.class);
            customer =  query.setParameter("custId", id).getSingleResult();
            customer.setEmail(email);
            em.persist(customer);
            et.commit();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            em.close();
        }
        return customer;
    }


    public static  Customer deleteCustomerById(int id){
        EntityManager em =  ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et  =null;
        Customer  customer =  null ;
        try{
            TypedQuery<Customer> query  = em.createQuery("SELECT c FROM Customer c WHERE c.custId = :custId",Customer.class);
            customer = query.setParameter("custId", id).getSingleResult();
            et = em.getTransaction();
            et.begin();
            em.remove(customer);
            et.commit();
        }catch (Exception ex){
            if(et != null) et.rollback();
            ex.printStackTrace();
        }finally {
            em.close();
        }
        return customer;
    }
}

