package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    class Solution {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        public List<List<Integer>> combine(int n, int k) {
            huisu(k,new ArrayList<>(),1,n);
            return res;
        }

        public void huisu(int k,ArrayList<Integer> path,int start,int n){
            if(path.size()==k){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i=start;i<=n;i++){
                path.add(i);
                huisu(k,path,i+1,n);
                path.remove(path.size()-1);
            }
        }
    }
}
