package com.jhj.algorithm.leetcode;

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int n=matrix.length;
    int m=matrix[0].length;
    int starthang=0;
    int startlie=m-1;
    while (startlie>=0&&starthang<n){
      if(matrix[starthang][startlie]==target){
        return true;
      }else if(matrix[starthang][startlie]>target){
        startlie--;
      }else{
        starthang++;
      }
    }
    return false;
  }
}