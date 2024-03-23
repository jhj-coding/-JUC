package com.jhj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    class Solution {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        public List<List<Integer>> combinationSum3(int k, int n) {

            huisu(k,n,new ArrayList<>(),1);
            return res;
        }
        public void huisu(int k,int n,ArrayList<Integer> path,int start){
            if(n<0||path.size()>k){
                return;
            }
            if(n==0 && path.size()==k){
                res.add(new ArrayList<>(path));
                return;
            }

            for(int i=start;i<=9;i++){
                path.add(i);
                huisu(k,n-i,path,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
