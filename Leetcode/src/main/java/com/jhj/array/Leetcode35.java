package com.jhj.array;

public class Leetcode35 {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left=0;
            int right=nums.length;
            int mid=0;
            boolean flag=true;
            while(left<right){
                mid=left+((right-left)>>1);
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    flag=true;
                    left=mid+1;
                }else{
                    flag=false;
                    right=mid;
                }
            }
            return left;
        }
    }
}
