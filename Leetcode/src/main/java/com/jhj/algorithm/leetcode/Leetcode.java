package com.jhj.algorithm.leetcode;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i] <= j && f[j - coins[i]] != Integer.MAX_VALUE) {
                    f[j] = Math.min(f[j - coins[i]] + 1, f[j]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }
}

