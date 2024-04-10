package com.jhj.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;

class Solution {
    HashSet<String> strings;
    int[] f;
    public boolean wordBreak(String s, List<String> wordDict) {
        strings = new HashSet<>(wordDict);
        f = new int[s.length()];
        return huisu(s,0);
    }
    public boolean huisu(String s,int startIndex){
        if(startIndex==s.length()){
            return true;
        }
        if(f[startIndex]==-1){
            return false;
        }
        for(int i=startIndex;i<s.length();i++){
            String substring = s.substring(startIndex, i + 1);
            if(!strings.contains(substring)){
                continue;
            }
            boolean huisu = huisu(s, i + 1);
            if(huisu) return true;
        }
        f[startIndex]=-1;
        return false;
    }
}
