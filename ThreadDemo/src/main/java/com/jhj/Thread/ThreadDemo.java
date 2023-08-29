package com.jhj.Thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"是守护"+Thread.currentThread().isDaemon());
            while (true){

            }
        }, "t1");
//        t1.setDaemon(true);
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
