package com.jhj.juc.count_down_latch;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Test {
    volatile ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Test t = new Test();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Thread(()->{
            System.out.println("t1 start");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        }).start();

        new Thread(()->{
            System.out.println("t2 start");
            for (int i=0;i<=9;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.list.add(i);
                System.out.println("add"+i);

                    countDownLatch.countDown();

            }
            System.out.println("t2 end");
        }).start();
    }
}
