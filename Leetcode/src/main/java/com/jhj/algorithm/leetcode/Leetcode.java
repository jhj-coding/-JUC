package com.jhj.algorithm.leetcode;


public class Leetcode {
    class Solution {
        public String convertToBase7(int num) {
            if(num==0){
                return "0";
            }
            boolean flag=true;
            if(num<0){
                flag=false;
                num=-num;
            }
            StringBuilder res = new StringBuilder();
            while (num!=0){
                res.insert(0,num%7);
                num/=7;
            }
            return flag?res.toString():res.insert(0,"-").toString();
        }
    }
}
