package com.jhj.algorithm.leetcode;


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

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param n int整型 
         * @return bool布尔型
         */
        public boolean NimGame (int n) {
            // write code here
            return n%4!=0;
        }
    }

}
