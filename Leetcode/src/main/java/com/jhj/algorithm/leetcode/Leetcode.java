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
        public List<Double> averageOfLevels(TreeNode root) {
            ArrayList<Double> res = new ArrayList<>();
            if(root==null){
                return res;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (!deque.isEmpty()){
                int size = deque.size();
                long sum=0;
                int n=size;
                while (size-->0){
                    TreeNode treeNode = deque.removeFirst();
                    if(treeNode.left!=null){
                        deque.addLast(treeNode.left);
                    }
                    if(treeNode.right!=null){
                        deque.addLast(treeNode.right);
                    }
                    sum+=treeNode.val;
                }
                res.add(sum*1.0/n);
            }
            return res;
        }
    }
}
