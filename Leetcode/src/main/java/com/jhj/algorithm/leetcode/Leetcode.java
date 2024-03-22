package com.jhj.algorithm.leetcode;


public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        TreeNode pre=null;
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }
            if(!isValidBST(root.left)){
                return false;
            };
            if(pre!=null&&root.val<=pre.val){
                return false;
            }
            pre=root;
            return isValidBST(root.right);
        }
    }
}
