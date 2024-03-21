package com.jhj.algorithm.leetcode;


import java.util.*;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组 
         * @param k int整型 
         * @return int整型一维数组
         */
        public int[] minSlidingWindow (int[] nums, int k) {
            // write code here
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int n=nums.length;
            int[] res=new int[n-k+1];
            for(int i=0;i<n;i++){
                while (!deque.isEmpty()&&deque.peekFirst()<i-k+1){
                    deque.pollFirst();
                }

                while (!deque.isEmpty()&&nums[deque.peekLast()]>nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(i);
                if(i>=k-1){
                    res[i-k+1]=nums[deque.peekFirst()];
                }
            }

            return res;
        }
    }
}
