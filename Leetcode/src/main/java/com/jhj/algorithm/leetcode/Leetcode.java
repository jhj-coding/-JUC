package com.jhj.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> strings = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length() + 1];
        f[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i&&!f[i];j++){
                if(strings.contains(s.substring(j,i))&&f[j]){
                    f[i]=true;
                }
            }
        }
        return f[s.length()];
    }
}
