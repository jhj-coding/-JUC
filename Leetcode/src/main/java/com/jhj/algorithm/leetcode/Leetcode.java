package com.jhj.algorithm.leetcode;


import java.util.Arrays;

public class Leetcode {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @param k int整型
         * @return int整型
         */
        public int numKLenSubstrRepeats (String s, int k) {
            // write code here
            int[] a = new int[26];
            Arrays.fill(a,0);
            if(k>s.length()){
                return 0;
            }
            int i=0;
            int j=k;
            for(int l=i;l<j;l++){
                a[s.charAt(l)-'a']++;
            }
            int res=0;
            if(panduan(a)){
                res++;
            }
            while (j<s.length()){
                a[s.charAt(i)-'a']--;
                a[s.charAt(j)-'a']++;
                if(panduan(a)){
                    res++;
                }
                i++;
                j++;
            }
            return res;
        }

        public boolean panduan(int a[]){

            for(int i=0;i<26;i++){
                if(a[i]>=2){
                    return true;
                }
            }
            return false;
        }
    }
}
