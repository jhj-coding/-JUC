package com.jhj.algorithm.leetcode;


public class Leetcode {
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
    class Solution {
        int res = 0;
        int path = 0;

        public int sumNumbers(TreeNode root) {
            dfs(root);
            return res;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                System.out.println(path*10+root.val);
                res += path*10+root.val;
                return;
            }
            path = path*10 + root.val;
            if(root.left!=null)
                dfs(root.left);
            if(root.right!=null)
                dfs(root.right);
            path/=10;
        }
    }
}
