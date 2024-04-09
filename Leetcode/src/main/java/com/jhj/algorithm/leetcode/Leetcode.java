package com.jhj.algorithm.leetcode;

class Solution {
    public int mySqrt(int x) {
        for (int i = 1; i <= x; i++) {
            if ((long)i * i > x) {
                return i - 1;
            }else  if ((long)i * i == x) {
                return i;
            }
        }
        return 0;
    }
}
