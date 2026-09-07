package BootCamp_SpringBoot.Day_3;

import java.util.Arrays;

public class Hello {
    public static void main(String[] args) throws InterruptedException {
//        MyThread1 thread1 = new MyThread1();
//        thread1.start();

//        MyThread2 thread2 = new MyThread2();
//        thread2.start();

//        MyThread3 thread3 = new MyThread3();
//        Thread th1 = new Thread(thread3);
//        th1.start();

        Runnable task = ()->{
            for (int i = 0; i < 400; i++) {
                System.out.println("Runnable Thread");
            }
        };
        Thread th2 = new Thread(task);
        th2.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("Hello " + i);
//            Thread.sleep(3000);
        }

        /*
        Thread Priority 1 - 10
        bydefault = 5

         */
    }
}
