package com.jhj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;

class Solution {
  public int countWays(int[][] ranges) {
    ArrayList<int[]> ints = new ArrayList<>();
    for (int i = 0; i < ranges.length; i++) {
      ints.add(ranges[i]);
    }
    ints.sort(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
      }
    });
    ArrayList<int[]> res = new ArrayList<>();
    res.add(ints.get(0));
    for (int i = 1; i < ints.size(); i++) {
      if (ints.get(i)[0] <= res.get(res.size() - 1)[1]) {
        res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], ints.get(i)[1]);
      } else {
        res.add(ints.get(i));
      }
    }
    System.out.print(quickPow(res.size()));
    return (int)quickPow(res.size());
  }

  public long quickPow(int n) {
    long mod = 1000000007;
    long res = 1;
    long x = 2;
    while (n != 0) {
      if (n % 2 == 1) {
        res *= x;
        res %= mod;
        x *= x;
        x %= mod;
      } else {
        x *= x;
        x %= mod;
      }
      n /= 2;
    }
    return res;
  }
}