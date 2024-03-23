package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    class Solution {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            huisu(candidates,target,0,new ArrayList<>());
            return res;
        }

        private void huisu(int[] candidates, int target, int start, ArrayList<Integer> path) {
            if(target<0){
                return;
            }
            if(target==0){
                res.add(new ArrayList<>(path));
                return;
            }

            for(int i=start;i<candidates.length;i++){
                path.add(candidates[i]);
                huisu(candidates,target-candidates[i],i,path);
                path.remove(path.size()-1);
            }
        }

    }
}
