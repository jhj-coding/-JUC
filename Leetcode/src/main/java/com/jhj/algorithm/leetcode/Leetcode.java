package com.jhj.algorithm.leetcode;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] f = new int[n][n];
        f[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            f[i][0]=f[i-1][0]+triangle.get(i).get(0);
            for(int j=1;j<i;j++){
                f[i][j]=Math.min(f[i-1][j],f[i-1][j-1])+triangle.get(i).get(j);
            }
            f[i][i]=f[i-1][i-1]+triangle.get(i).get(i);
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res=Math.min(res,f[n-1][i]);
        }
        return res;
    }
}