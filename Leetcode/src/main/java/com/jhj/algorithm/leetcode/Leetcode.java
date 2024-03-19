package com.jhj.algorithm.leetcode;


import java.util.HashMap;

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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i],i);
            }
            return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
        }
        public TreeNode build(int[] inorder, int[] postorder,int istart,int iend,int pstart,int pend,HashMap<Integer,Integer> map){
            if(istart>iend||pstart>pend){
                return null;
            }
            int rv = postorder[pend];
            Integer index = map.get(rv);
            TreeNode root = new TreeNode(rv);
            root.left= build(inorder,postorder,istart,index-1,pstart,index-1-istart+pstart,map);
            root.right= build(inorder,postorder,index+1,iend,pend-iend+index,pend-1,map);
            return root;
        }
    }
}
