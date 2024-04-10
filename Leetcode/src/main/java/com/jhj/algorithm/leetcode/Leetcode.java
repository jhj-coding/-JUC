package com.jhj.algorithm.leetcode;

class Solution {
    public int maximumCount(int[] nums) {
        int left=0;
        int len=nums.length;
        if(nums[left]>0){
            return len;
        }
        int right=len-1;
        while (left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]>=0){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        int l0=right;
        left=0;
        right=len-1;
        while (left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]<=0){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        int l1=left;
        return Math.max(l0+1,len-l1);
    }
}

