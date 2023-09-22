package com.jhj.array;

import java.util.ArrayList;
import java.util.HashMap;

public class One {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return build(postorder,0,postorder.length,inorder,0,inorder.length);
    }
    public TreeNode build(int[] postorder,int pstart,int pend, int[] inorder,int istart,int iend){
        if(pstart>=pend||istart>=iend){
            return null;
        }
        int rootIndex= map.get(postorder[pend-1]);
        TreeNode root=new TreeNode(postorder[pend-1]);
        root.left=build(postorder,pstart,pstart+rootIndex-istart,inorder,istart,rootIndex);
        root.right=build(postorder,pstart+rootIndex-istart,pend-1,inorder,rootIndex+1,iend);
        return root;
    }

    //108
    class Solution108 {
        public TreeNode sortedArrayToBST(int[] nums) {
            ArrayList<Integer> objects = new ArrayList<Integer>();
            return null;
        }
        public TreeNode b(int left,int right,int[] nums){
            if(left>right){
                return null;
            }
            int index= (right-left)/2+left;
            TreeNode root = new TreeNode(nums[index]);
            root.left=b(left,index-1,nums);
            root.right=b(index+1,right,nums);
            return root;
        }
    }
    //110
    class Solution110 {
        public int get(TreeNode root){
            if(root==null){
                return 0;
            }
            int i = get(root.left);
            if(i==-1) return -1;
            int i1 = get(root.right);
            if(i1==-1) return -1;

            return Math.abs(i-i1)>1?-1:1+Math.max(i,i1);

        }
        public boolean isBalanced(TreeNode root) {
            return get(root)!=-1;
        }
    }
    //7
    class Solution7 {
        public int reverse(int x) {
            String.valueOf(x);
            return 1;
        }
    }
    //8
    class Solution8 {
        public int myAtoi(String s) {
            s=s.trim();
            int j=0;
            while(s.charAt(j)=='0' && j<s.length()){
                j++;
            }
            if(j==s.length()){
                return 0;
            }
            int res=s.charAt(j-1)-'0';
            Boolean flag=true;
            while (('0'<=s.charAt(j) && s.charAt(j)<='9')|| s.charAt(j)=='-'||s.charAt(j)=='+' && j<s.length()){
                if(s.charAt(j)=='-'||s.charAt(j)=='+'||s.charAt(j)=='+'){
                    flag=s.charAt(j)=='-';
                }else {
                    res=res*10+(s.charAt(j)-'0');
                }
                j++;
            }
            if (flag){
                return -res;
            }else{
                return res;
            }
        }
    }
    public static void main(String[] args) {

        System.out.println(String.valueOf(-1%10));
    }
}
