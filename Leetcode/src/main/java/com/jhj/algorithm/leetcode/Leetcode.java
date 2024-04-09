package com.jhj.algorithm.leetcode;

class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        int[] f = new int[len + 1];
        f[0]=0;
        f[1]=nums[0];
        for(int i=1;i<len;i++){
            f[i+1]=Math.max(f[i-1]+nums[i],f[i]);
        }
        return Math.max(f[len],f[len-1]);
    }
}

