package com.jhj.algorithm.leetcode;

import java.util.*;

class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n=profits.length;
    int[][] arr = new int[n][2];
    for(int i=0;i<n;i++){
      arr[i]=new int[]{capital[i],profits[i]};
    }
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
    int curr=0;
    for(int i=0;i<k;i++){
      while (curr<n&&arr[curr][0]<=w){
        priorityQueue.add(arr[curr][1]);
        curr++;
      }
      if (!priorityQueue.isEmpty()) {
        w += priorityQueue.poll();
      } else {
        break;
      }
    }
    return w;
  }
}
