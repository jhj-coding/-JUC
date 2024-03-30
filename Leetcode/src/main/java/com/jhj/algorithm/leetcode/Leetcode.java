package com.jhj.algorithm.leetcode;

import java.util.*;

class MedianFinder {
  PriorityQueue<Integer> leftQueue;
  PriorityQueue<Integer> rightQueue;
  public MedianFinder() {
    leftQueue=new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    rightQueue=new PriorityQueue<>();
  }

  public void addNum(int num) {
    if(leftQueue.isEmpty() || num<=leftQueue.peek()){
      leftQueue.add(num);
      while (leftQueue.size()-rightQueue.size()>1){
        rightQueue.add(leftQueue.remove());
      }
    }else {
      rightQueue.add(num);
      while (rightQueue.size() - leftQueue.size() > 0) {
        leftQueue.add(rightQueue.remove());
      }
    }
  }

  public double findMedian() {
    if(leftQueue.size()>rightQueue.size()){
      return leftQueue.peek();
    }else{
      return (leftQueue.peek()+rightQueue.peek())/2.0;
    }
  }
}