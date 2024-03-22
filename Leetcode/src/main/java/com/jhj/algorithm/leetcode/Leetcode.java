package com.jhj.algorithm.leetcode;


import java.util.ArrayDeque;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class Solution {
        public int numIslands(char[][] grid) {
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            int m=grid.length;
            int n=grid[0].length;
            int res=0;
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if(grid[i][j]=='1'){
                        grid[i][j]='0';
                        deque.add(new int[]{i,j});
                        res++;
                        while (!deque.isEmpty()){
                            int[] ints = deque.removeFirst();
                            int h = ints[0];
                            int l = ints[1];
                            int k=h+1;
                            int p=l;
                            if(k<0||k>=m||p<0||p>=n||grid[k][p]!='1'){

                            }else{
                                grid[k][p]='0';
                                deque.add(new int[]{k,p});
                            }
                            k=h-1;
                            p=l;
                            if(k<0||k>=m||p<0||p>=n||grid[k][p]!='1'){

                            }else{
                                grid[k][p]='0';
                                deque.add(new int[]{k,p});
                            }
                            k=h;
                            p=l+1;
                            if(k<0||k>=m||p<0||p>=n||grid[k][p]!='1'){

                            }else{
                                grid[k][p]='0';
                                deque.add(new int[]{k,p});
                            }
                            k=h;
                            p=l-1;
                            if(k<0||k>=m||p<0||p>=n||grid[k][p]!='1'){

                            }else{
                                grid[k][p]='0';
                                deque.add(new int[]{k,p});
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
