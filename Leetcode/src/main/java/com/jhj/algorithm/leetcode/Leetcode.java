package com.jhj.algorithm.leetcode;

class Solution {
  public int search(int[] nums, int target) {
    int left=0;
    int right=nums.length-1;
    while (left<=right){
      int mid=(left+right)>>1;
      if(nums[mid]==target){
        return mid;
      }
      if(nums[mid]>=nums[0]){
        if(target>=nums[0]&&target<nums[mid]){
          right=mid-1;
        }else{
          left=mid+1;
        }
      }else{
        if(target<=nums[nums.length-1]&&target>nums[mid]){
          left=mid+1;
        }else {
          right=mid-1;
        }
      }
    }
    return -1;
  }
}