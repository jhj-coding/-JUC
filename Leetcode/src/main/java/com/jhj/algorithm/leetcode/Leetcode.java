package com.jhj.algorithm.leetcode;


public class Leetcode {
    class Solution {
        public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums,0,nums.length-1);
        }

        public TreeNode sortedArrayToBST(int[] nums,int left,int right) {
            if(left>right){
                return null;
            }
            int mid=(left+right)>>1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left=sortedArrayToBST(nums,left,mid-1);
            root.right=sortedArrayToBST(nums,mid+1,right);
            return root;
        }
    }
}
