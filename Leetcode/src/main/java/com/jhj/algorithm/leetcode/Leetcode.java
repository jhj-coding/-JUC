package com.jhj.algorithm.leetcode;

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m=nums1.length;
    int n=nums2.length;
    int ji=(m+n+1)/2;
    int ou=(m+n+2)/2;
    return (getK(nums1,nums2,ji,0,m-1,0,n-1)+getK(nums1,nums2,ou,0,m-1,0,n-1))/2.0;
  }
  public int getK(int[] nums1,int[] nums2,int k,int left1,int right1,int left2,int right2){
    int len1=right1-left1+1;
    int len2=right2-left2+1;
    if(len1>len2){
      return getK(nums2,nums1,k,left2,right2,left1,right1);
    }
    if(len1==0){
      return nums2[left2+k-1];
    }
    if(k==1){
      return Math.min(nums1[left1],nums2[left2]);
    }
    int i=Math.min(left1+k/2-1,right1);
    int j=Math.min(left2+k/2-1,right2);
    if(nums1[i]>nums2[j]){
      return getK(nums1,nums2,k-(j+1-left2),left1,right1,j+1,right2);
    }else{
      return getK(nums1,nums2,k-(i+1-left1),i+1,right1,left2,right2);
    }
  }
}