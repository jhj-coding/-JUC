package com.jhj.algorithm.leetcode;

import java.util.Arrays;

class Solution {
  public int minOperations(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int m = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[m++] = nums[i]; // 原地去重
      }
    }

    int ans = 0;
    int left = 0;
    for (int i = 0; i < m; i++) {
      while (nums[left] < nums[i] - n + 1) { // nums[left] 不在窗口内
        left++;
      }
      ans = Math.max(ans, i - left + 1);
    }
    return n - ans;
  }
}
