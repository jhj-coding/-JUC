package com.jhj.juc.phaser;

import java.util.concurrent.Phaser;

public class Test {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        for(int i=0;i<10;i++){
            phaser.register();
            new Thread(new player(phaser),"player"+i).start();
        }
        System.out.println("Game Start");
        phaser.arriveAndDeregister();
        //是否非终止态一直等待
        while(!phaser.isTerminated()){
        }
        System.out.println("Game Over");
    }
    static class player implements Runnable{

        private  final Phaser phaser ;

        player(Phaser phaser){
            this.phaser=phaser;
        }
        @Override
        public void run() {
            try {
                // 第一阶段——等待创建好所有线程再开始
                phaser.arriveAndAwaitAdvance();

                // 第二阶段——等待所有选手准备好再开始
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + " ready");
                phaser.arriveAndAwaitAdvance();

                // 第三阶段——等待所有选手准备好到达，到达后，该线程从phaser中注销，不在进行下面的阶段。
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(Thread.currentThread().getName() + " arrived");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
