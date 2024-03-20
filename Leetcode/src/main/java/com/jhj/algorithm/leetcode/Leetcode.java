package com.jhj.algorithm.leetcode;


import java.util.ArrayList;

public class Leetcode {

//     * Definition for a binary tree node.
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
          ArrayList<Integer> list=new ArrayList<Integer>();
        public int countNodes(TreeNode root) {

            dfs(root);
            return list.size();
        }
        public void dfs(TreeNode root){
            if(root==null){
                return;
            }
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
