package com.jhj.algorithm.leetcode;

import java.util.Arrays;

class Solution {
  public int minimumAddedCoins(int[] coins, int target) {
    Arrays.sort(coins);
    int ans=0,s=1,i=0;
    while (s <= target) {
      if (i < coins.length && coins[i] <= s) {
        s += coins[i++];
      } else {
        s *= 2; // 必须添加 s
        ans++;
      }
    }
    return ans;
  }
}