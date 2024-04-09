package com.jhj.algorithm.leetcode;

class Solution {
    public int[] plusOne(int[] digits) {
        int res=1;
        int len=digits.length;
        for(int i=len-1;i>=0;i--){
            res=digits[i]+res;
            digits[i]=res%10;
            res/=10;
        }
        if(res==0){
            return digits;
        }
        int[] ints = new int[len + 1];
        ints[0]=res;
        for (int i=1;i<len+1;i++){
            ints[i]=digits[i-1];
        }
        return ints;
    }
}
