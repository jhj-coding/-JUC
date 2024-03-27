package com.jhj.algorithm.leetcode;

class Solution {
  public int[] searchRange(int[] nums, int target) {
    if(nums.length==0){
      return new int[]{-1,-1};
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) >> 1;
      if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int temp = right+1;
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) >> 1;
      if (target >= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if(temp<nums.length&&left>=1&&temp<left&&nums[temp]==target){
      return new int[]{temp,left-1};
    }else{
      return new int[]{-1,-1};
    }
  }
}