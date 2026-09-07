package BootCamp_SpringBoot.Day_3;

public class MyThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("Runnable Thread");
        }
    }
}
