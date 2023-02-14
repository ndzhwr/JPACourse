package me.rexisn.Catprep.threading;

public class Main {
    public static int c = 9;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(new Wkr());
        worker.start();
        System.out.println(c);
   worker.join();
        System.out.println(c);
    }
}
