package com.jhj.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    for(int i=0;i<nums.length;i++){
      priorityQueue.add(nums[i]);
    }
    for (int i=1;i<k;i++){
      priorityQueue.remove();

    }
    return priorityQueue.remove();
  }
}