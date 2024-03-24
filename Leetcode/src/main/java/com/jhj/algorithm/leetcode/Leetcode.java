package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    class Solution {
        List<String> res=new ArrayList<>();
        public List<String> generateParenthesis(int n) {

            dfs(n,n,new StringBuilder());
            return res;
        }

        private void dfs(int left, int right, StringBuilder stringBuilder) {
            if(left==right&&left==0){
                res.add(stringBuilder.toString());
                return;
            }
            if(left>0){
                stringBuilder.append("(");
                dfs(left-1,right,stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
            if(right>0 && left<right){
                stringBuilder.append(")");
                dfs(left,right-1,stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }

    }
}
