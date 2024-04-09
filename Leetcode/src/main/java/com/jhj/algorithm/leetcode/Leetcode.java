package com.jhj.algorithm.leetcode;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int c = x;
        int res = 0;
        while (c != 0) {
            res = res * 10 + c % 10;
            c /= 10;
        }
        return res == x;
    }
}
