package com.jhj.algorithm.leetcode;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            Arrays.fill(ret, -1);
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < n * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ret[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return ret;
        }
    }
}
