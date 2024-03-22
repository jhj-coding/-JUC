package com.jhj.algorithm.leetcode;


public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {

        int res=Integer.MAX_VALUE;
        TreeNode pre=null;
        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return res;
        }

        public void dfs(TreeNode root){
            if(root==null){
                return;
            }
            dfs(root.left);
            if(pre!=null){
                res=Math.min(root.val-pre.val,res);
            }
            pre=root;
            dfs(root.right);
        }

    }
}
