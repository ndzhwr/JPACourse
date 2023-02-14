package me.rexisn.Catprep.threading;

public class Wkr extends  Thread{
    @Override
    public void run() {
        Main.c = 10;
    }
}
