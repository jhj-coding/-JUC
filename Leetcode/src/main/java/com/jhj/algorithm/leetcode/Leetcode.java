package com.jhj.algorithm.leetcode;


public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @param t string字符串
         * @return string字符串
         */
        public String minWindow (String s, String t) {
            // write code here
            int[] hash = new int[128];
            for(int i=0;i<t.length();i++){
                hash[t.charAt(i)]--;
            }
            int left =0;
            int right=0;
            boolean isFind=false;
            String res=s;
            while (right<s.length()){
                hash[s.charAt(right)]++;
                while (check(hash)){
                    isFind=true;
                    if(res.length() > right - left + 1){
                        res = s.substring(left , right + 1);
                    }
                    hash[s.charAt(left)]--;
                    left++;
                }
                right++;
            }
            return isFind ? res : "";
        }
        boolean check(int[] hash){
            for (int i : hash) {
                if(i < 0)
                    return false;
            }
            return true;
        }
    }
}
