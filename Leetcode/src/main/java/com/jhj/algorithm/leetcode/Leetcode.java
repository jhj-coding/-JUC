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
            int[] ts = new int[128];
            for(int i=0;i<t.length();i++){
                ts[t.charAt(i)]++;
            }
            int left=0;
            int right=0;
            String res=s;
            boolean flag=false;
            while (right<s.length()){
                char c = s.charAt(right);
                ts[c]--;
                while (check(ts)){
                    flag=true;
                    res=res.length()>right-left+1?s.substring(left,right+1):res;
                    char c1 = s.charAt(left);
                    ts[c1]++;
                    left++;
                }
                right++;
            }
            return flag?res:"";
        }

        private boolean check(int[] ts) {
            for(int i=0;i<ts.length;i++){
                if(ts[i]>0){
                    return false;
                }
            }
            return true;
        }
    }
}
