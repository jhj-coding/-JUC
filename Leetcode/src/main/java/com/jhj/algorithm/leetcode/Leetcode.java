package com.jhj.algorithm.leetcode;


class Solution {
  public int maxSubarraySumCircular(int[] nums) {
    int max = nums[0];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum < nums[i]) {
        sum = nums[i];
      }
      max = Math.max(max, sum);
    }
    int min = nums[0];
    int summin = 0;
    int s = 0;
    for (int i = 0; i < nums.length; i++) {
      s += nums[i];
      summin+=nums[i];
      if (summin > nums[i]) {
        summin = nums[i];
      }
      min = Math.min(min, summin);
    }
    if (max < 0) {
      return max;
    } else {
      return Math.max(max, s - min);
    }
  }
}
