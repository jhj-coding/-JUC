package com.jhj.algorithm.leetcode;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode {

//     * Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public String[] findRelativeRanks(int[] score) {
            String[] strings = new String[score.length];
            TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for(int i=0;i<score.length;i++) {
                map.put(score[i],i);
            }
            int i=1;
            for(Map.Entry<Integer,Integer> e:map.entrySet()) {
                if(i==1) {
                    strings[e.getValue()] = String.valueOf("Gold Medal");
                }else if(i==2) {
                    strings[e.getValue()] = String.valueOf("Bronze Medal");

                }else if(i==3) {
                    strings[e.getValue()] = String.valueOf("Silver Medal");

                }else {
                    strings[e.getValue()] = String.valueOf(i);
                }
                i++;
            }
            return strings;
        }
    }

}
