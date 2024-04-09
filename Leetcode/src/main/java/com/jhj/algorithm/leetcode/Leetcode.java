package com.jhj.algorithm.leetcode;

class Solution {
    public int climbStairs(int n) {
        int a=1;
        int b=1;
        for(int i=2;i<=n;i++){
            int temp=a;
            a=b;
            b=temp+b;
        }
        return b;
    }
}

