package me.rexisn.Catprep.threading;

public class Worker extends  Thread {
    @Override
    public void run() {
        System.out.println("Worker says wassup");
    }

    public void testInterruptions(){
        for(int i = 0; i < 60 ; i++){
            System.out.println("Worker is on " + i);
            if (i == 45){
                interrupt();
            }
            if (interrupted()){
                System.out.println("Worker thread was interrupted on  " + i);
            }
        }
    }
}
