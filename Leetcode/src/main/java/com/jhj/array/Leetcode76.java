package com.jhj.array;

public class Leetcode76 {
    class Solution {
        public String minWindow(String s, String t) {
            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            int[] i1=new int[123];
            int[] i = new int[123];
            for(int k=0;k<chars1.length;k++){
                i1[chars1[k]]++;
            }
            int l=0;
            int r=0;
            int distance=0;
            int min=chars.length+1;
            int begin=0;
            while(r<chars.length){
                if(i1[chars[r]]==0){
                    r++;
                    continue;
                }
                if(i[chars[r]]<i1[chars[r]]){
                    distance++;
                }
                i[chars[r]]++;
                while (distance==chars1.length){
                    if(r-l+1<min){
                        min=r-l+1;
                        begin=l;
                    }
                    if(i1[chars[l]]==0){
                        l++;
                        continue;
                    }
                    if(i[chars[l]]==i1[chars[l]]){
                        distance--;
                    }
                    i[chars[l]]--;
                    l++;
                }
                r++;
            }
            if(min==chars.length+1){
                return "";
            }else{
                return s.substring(begin,begin+min);
            }
        }
    }
}
