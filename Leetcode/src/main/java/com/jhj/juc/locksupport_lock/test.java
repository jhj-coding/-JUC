package com.jhj.juc.locksupport_lock;

import java.util.concurrent.locks.LockSupport;

class MyThread extends Thread {
    private Object object;

    public MyThread(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unlock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("锁信息"+LockSupport.getBlocker((Thread) object));
        LockSupport.unpark((Thread) object);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("锁信息"+LockSupport.getBlocker((Thread) object));
        System.out.println("after unlock");
    }
}

public class test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(Thread.currentThread());
        myThread.start();
        System.out.println("before lock");
        LockSupport.park("我是park");
        System.out.println("after lock");
    }
}