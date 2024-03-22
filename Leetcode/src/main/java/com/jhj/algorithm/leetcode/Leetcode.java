package com.jhj.algorithm.leetcode;


public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        int res=0;
        int count=0;
        public int kthSmallest(TreeNode root, int k) {
            dfs(root,k);
            return res;
        }
        public void dfs(TreeNode root,int k){
            if(root==null){
                return;
            }
            dfs(root.left,k);
            count++;
            if(count==k){
                res=root.val;
                return;
            }
            dfs(root.right,k);
        }
    }
}
