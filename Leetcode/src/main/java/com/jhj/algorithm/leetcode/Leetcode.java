package com.jhj.algorithm.leetcode;


public class Leetcode {
    class Solution {
        int res=0;
        public int totalNQueens(int n) {
            char[][] chars = new char[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    chars[i][j]='.';
                }
            }
            huisu(n,0,chars);
            return res;
        }
        public void huisu(int n,int rowIndex,char[][] chars){
            if(n==rowIndex){
                res++;
                return;
            }
            for(int i=0;i<n;i++){
                boolean flag=true;
                for(int j=0;j<rowIndex;j++){
                    if(chars[j][i]=='Q'){
                        flag=false;
                        break;
                    }
                }
                for (int h = rowIndex - 1, l = i - 1; l >= 0 && h >= 0; l--, h--) {
                    if (chars[h][l] == 'Q') {
                        flag = false;
                        break;
                    }
                }

                for (int h = rowIndex - 1, l = i + 1; h >= 0 && l < n; l++, h--) {
                    if (chars[h][l] == 'Q') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    chars[rowIndex][i] = 'Q';
                    huisu(n, rowIndex + 1, chars);
                    chars[rowIndex][i] = '.';
                }
            }
        }
    }
}
