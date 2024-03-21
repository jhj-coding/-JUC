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
        public List<Integer> rightSideView(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if(root==null){
                return res;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()){
                int size = deque.size();
                while (size-->0){
                    TreeNode treeNode = deque.removeFirst();

                    if(treeNode.left!=null){
                        deque.addLast(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        deque.addLast(treeNode.right);
                    }
                    if(size==0){
                        res.add(treeNode.val);
                    }
                }
            }
            return res;
        }
    }
}
