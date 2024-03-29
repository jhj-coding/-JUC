package com.jhj.algorithm.leetcode;

class Solution {
  public int minimumSum(int[] nums) {
    int sum = Integer.MAX_VALUE;
    int len = nums.length;
    for (int i = 0; i < len - 2; i++) {
      for (int j = i + 1; j < len - 1; j++) {
        for (int k = j + 1; k < len; k++) {
          if (nums[i] < nums[j] && nums[k] < nums[j]) {
            sum = Math.min(sum, nums[i] + nums[j] + nums[k]);
          }
        }
      }
    }
    if (sum == Integer.MAX_VALUE) {
      return -1;
    } else {
      return sum;
    }
  }
}