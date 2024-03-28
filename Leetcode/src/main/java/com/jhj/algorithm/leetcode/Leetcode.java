package com.jhj.algorithm.leetcode;

class Solution {
  public int firstDayBeenInAllRooms(int[] nextVisit) {
    final long MOD = 1_000_000_007;
    int n = nextVisit.length;
    long[] s = new long[n];
    for (int i = 0; i < n - 1; i++) {
      int j = nextVisit[i];
      s[i + 1] = (s[i] * 2 - s[j] + 2 + MOD) % MOD; // + MOD 避免算出负数
    }
    return (int) s[n - 1];
  }
}