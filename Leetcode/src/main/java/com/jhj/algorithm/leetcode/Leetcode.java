package com.jhj.algorithm.leetcode;


public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            int i=0;
            int j=0;
            for(;j<n;j++){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
            j=j-1;
            for(;i<m;i++){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
            i--;
            for(;j>=0;j--){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
            j++;
            for(;i>=0;i--){
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }

            for(int k=0;k<m;k++){
                for (int l=0;l<n;l++){
                    if(board[k][l]=='O'){
                        board[k][l]='X';
                    } if(board[k][l]=='I'){
                        board[k][l]='O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
                return;
            }
            board[i][j]='I';
            dfs(board,i+1,j);
            dfs(board,i-1,j);
            dfs(board,i,j+1);
            dfs(board,i,j-1);
        }
    }
}
