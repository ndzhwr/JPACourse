package me.rexisn.JPACourse;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id()
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int custId;

    @Column(name = "Email_Address", unique = true, nullable = false)
    private String email;


    @Column(name = "FirstName", unique = true, nullable = false)
    private String fname;

    @Column(name = "LastName", nullable = false, unique = true)
    private String lfname;

    Customer(String email, String fname, String lfname){
    this.email = email;
    this.fname = fname;
     this.lfname = lfname;
    }

    public Customer() {

    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLfname() {
        return lfname;
    }

    public void setLfname(String lfname) {
        this.lfname = lfname;
    }
}
