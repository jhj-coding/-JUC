package com.jhj.algorithm.leetcode;

class Solution {
  public String addBinary(String a, String b) {
    int lena=a.length();
    int lenb=b.length();
    StringBuilder s = new StringBuilder();
    int res=0;
    while (lena>0||lenb>0){
      if(lena>0&&lenb>0){
        char ca = a.charAt(--lena);
        char cb = b.charAt(--lenb);
        res+=(ca-'0')+(cb-'0');
        s.insert(0,res%2);
        res/=2;
      }else if(lena>0){
        char ca = a.charAt(--lena);
        res+=(ca-'0');
        s.insert(0,res%2);
        res/=2;
      }else{
        char cb = b.charAt(--lenb);
        res+=(cb-'0');
        s.insert(0,res%2);
        res/=2;
      }
    }
    if(res!=0){
      s.insert(0,res%2);
    }
    return s.toString();
  }
}
