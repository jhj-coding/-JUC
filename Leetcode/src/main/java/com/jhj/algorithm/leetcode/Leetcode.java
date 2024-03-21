package com.jhj.algorithm.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if(root==null){
                return res;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()){
                ArrayList<Integer> list = new ArrayList<>();
                int size = deque.size();
                while (size-->0) {

                    TreeNode treeNode = deque.removeFirst();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                }
                res.add(list);
            }


            return res;
        }
    }
}
