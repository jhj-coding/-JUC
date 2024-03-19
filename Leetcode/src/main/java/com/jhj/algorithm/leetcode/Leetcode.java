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
        TreeNode head=new TreeNode(-100);
        TreeNode cur=head;
        public void flatten(TreeNode root) {
            if(root==null){
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left=null;
            root.right=null;
            cur.right=root;
            cur=cur.right;
            flatten(left);
            flatten(right);
            root=head.right;
        }
    }
}
