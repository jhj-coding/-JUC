package com.jhj.juc.fork_join;

import java.util.concurrent.*;

public class Test {
    static final class SumTask extends RecursiveTask<Integer>{
        final int start;
        final int end;
        SumTask(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        protected Integer compute() {
            if(end-start<1000){
                System.out.println(Thread.currentThread().getName()+"开始"+start+"-"+end);
                int sum=0;
                for (int i=start;i<=end;i++){
                    sum+=i;
                }
                return sum;
            }
            SumTask sumTask1 = new SumTask(start, (start + end) / 2);
            SumTask sumTask2 = new SumTask((start + end) / 2+1,end);
            sumTask1.fork();
            sumTask2.fork();
            return sumTask1.join()+sumTask2.join();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask sumTask = new SumTask(1, 10000);
        forkJoinPool.submit(sumTask);
        System.out.println(sumTask.get());
        System.out.println(System.currentTimeMillis()-l);
    }
}
