package me.rexisn.Catprep.threading;

public class Doer implements  Runnable {
    @Override
    public void run() {
        System.out.println("Doer says wassup");
    }
}
