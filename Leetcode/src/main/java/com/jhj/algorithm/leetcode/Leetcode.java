package com.jhj.algorithm.leetcode;

class Solution {
    public String maximumBinaryString(String binary) {
        char[] s = binary.toCharArray();
        int n=binary.length();
        int j=0;
        for(int i=0;i<n;i++){
            if(s[i]=='0'){
                while (j<=i||(j<n&&s[j]=='1')){
                    j++;
                }
                if(j<n){
                    s[j]='1';
                    s[i]='1';
                    s[i+1]='0';
                }
            }
        }
        return new String(s);
    }
}