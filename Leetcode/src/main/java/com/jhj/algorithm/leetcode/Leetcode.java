package com.jhj.algorithm.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if(root==null){
                return res;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.addLast(root);
            int count=0;
            while (!deque.isEmpty()){
                LinkedList<Integer> list = new LinkedList<>();
                int size=deque.size();
                while (size-->0) {
                    TreeNode treeNode = deque.removeFirst();
                    if(count%2==0) {
                        list.addLast(treeNode.val);
                    }else {
                        list.addFirst(treeNode.val);
                    }
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                }
                count++;
                res.add(list);
            }
            return res;
        }
    }
}
