package com.jhj.algorithm.leetcode;


public class Leetcode704 {

    class Solution {
        public int minIncrements(int n, int[] cost) {
            int ans=0;
            for(int i=n;i>=0;i-=2){
                ans+=Math.abs(cost[i]-cost[i-1]);
                cost[i/2]+=Math.max(cost[i],cost[i-1]);
            }
            return ans;
        }
    }
}
