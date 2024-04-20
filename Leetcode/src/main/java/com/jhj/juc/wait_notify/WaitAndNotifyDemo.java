package com.jhj.juc.wait_notify;

class MyThread extends Thread {
    
    public void run() {
        System.out.println("1111");
        synchronized (this){
            System.out.println("before notify");
            this.notify();
            System.out.println("after notify");
        }

    }
}

public class WaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(2000);
        synchronized (myThread){

            System.out.println("before await");
            myThread.wait();
            System.out.println("after await");
        }
    }
}