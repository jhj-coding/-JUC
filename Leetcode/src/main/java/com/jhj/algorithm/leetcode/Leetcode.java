package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    class Solution {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        public List<List<Integer>> permute(int[] nums) {
            huisu(nums,new ArrayList<Integer>());
            return res;
        }

        private void huisu(int[] nums, ArrayList<Integer> set) {
            if(set.size()==nums.length){
                res.add(new ArrayList<>(set));
                return;
            }

            for(int i=0;i<nums.length;i++){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    huisu(nums,set);
                    set.remove(set.size()-1);
                }
            }

        }
    }
}
