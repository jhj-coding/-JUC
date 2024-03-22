package com.jhj.algorithm.leetcode;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n=profits.length;
            int[][] arr = new int[n][2];
            for(int i=0;i<profits.length;i++){
                arr[i]=new int[]{capital[i],profits[i]};
            }
            Arrays.sort(arr,(a,b)->a[0]-b[0]);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
            int curr=0;
            for(int i=0;i<k;i++){
                while (curr<n&&arr[curr][0]<=w){
                    priorityQueue.add(arr[curr][1]);
                    curr++;
                }
                if(!priorityQueue.isEmpty()){
                     w+= priorityQueue.poll();
                }else{
                    break;
                }
            }
            return w;
        }
    }
}
