package me.rexisn.Catprep;

import me.rexisn.Catprep.custenums.Gender;
import me.rexisn.Catprep.generics.IterablePrinter;
import me.rexisn.Catprep.generics.Point;
import me.rexisn.Catprep.threading.Doer;
import me.rexisn.Catprep.threading.Worker;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Point<Double> mypt =  new Point<Double>();
        mypt.setX(new Double(4.2));
        mypt.setY(new Double(1.0));

        Point yourpt = new Point<Double>();
        yourpt.setX(new Double(4.2));
        yourpt.setY(new Double(1.0));
        System.out.println(mypt.location());
        System.out.println(mypt.<Point>isEqual(mypt,yourpt));


        System.out.println("________________________________________________");
        ArrayList numbers = new ArrayList();
        numbers.add(12);
        numbers.add(24);
        numbers.add(36);
        numbers.add(48);

        IterablePrinter.print(numbers);


        /* When we've not used generics to determine the type to be stored in
         *  the collection, Object data type is used.
         *  To mean, everything can be stored in  the collection
         */


        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        System.out.println("_____________________________________________");

        ArrayList things = new ArrayList(10);
        things.add(new String("NDIZIHIWE Regis"));
        things.add(17);
        things.add(new String("Musanze,Rwanda"));
        things.add(new Date());

        System.out.println(things.size());
        System.out.println(things.contains(17) ? "Contains  a mumber " : "No number included");
        for (int i = 0; i < things.size(); i++) {
            System.out.println(things.get(i));
        }
        System.out.println("_____________________________________________");

        HashSet peopleSet = new HashSet();
        peopleSet.add(new String("Zack"));
        peopleSet.add(new String("Dave"));
        // Sets never contain duplicate
        peopleSet.add(new String("Zack"));
        System.out.println(peopleSet.size());
        // way 1
        for (Object oo : peopleSet) {
            System.out.println(oo);
        }
        // way 2
        peopleSet.forEach(person -> {
            System.out.println(person);
        });


        // Using Maps
        Map<String, Integer> name2age = new HashMap<String, Integer>();
        name2age.put("leerob", 34);
        name2age.put("delba", 31);
        name2age.put("timneutkens", 22);
        name2age.put("leerob", 60);



        Integer leerobAge = new Integer(name2age.get("leerob"));
        System.out.println("Leerob is " + leerobAge + " years old");

        System.out.println("_____________________________________________");

        LinkedList playqueue = new LinkedList();
        playqueue.add(new String("Dendalions"));
        playqueue.add(new String("Sorry"));
        playqueue.add(new String("Ikinyafu"));

        System.out.println(playqueue.size());
            System.out.println(playqueue.get(0));
          //  System.out.println( playqueue.poll());
            System.out.println(playqueue.peek());

        System.out.println("_____________________________________________");

            playqueue.forEach(item -> System.out.println(item));
        System.out.println(new String("Regis").hashCode());

        System.out.println("_____________________________________________");

        ArrayList<String> morestuff = new ArrayList<String>();
        morestuff.add("Regii");
        morestuff.add(String.valueOf(2000));
        System.out.println(morestuff.get(0) instanceof  String);
        System.out.println(morestuff.get(1));

        System.out.println("____________________ENUMS_________________________");
        Gender delbagender = Gender.FEMALE ;
        System.out.println(delbagender.ordinal());


        System.out.println("_____________________THREADS_______________________");
        Worker worker1 = new Worker();
        Thread doerThread =  new Thread(new Doer());
        worker1.start();
        try{
            worker1.sleep(3000);
        }catch (InterruptedException ex){
            System.out.println(worker1.isInterrupted());
            System.out.println("Interrupted");
        }
        worker1.testInterruptions();
        doerThread.start();

    }
}

