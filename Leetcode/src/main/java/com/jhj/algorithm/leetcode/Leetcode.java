package com.jhj.algorithm.leetcode;

class Solution {
  public int singleNumber(int[] nums) {
    int a = 0, b = 0;
    for (int x : nums) {
      int tmpA = a;
      a = (a ^ x) & (a | b);
      b = (b ^ x) & ~tmpA;
    }
    return b;
  }
}
