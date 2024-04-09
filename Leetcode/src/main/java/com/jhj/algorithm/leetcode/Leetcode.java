package com.jhj.algorithm.leetcode;

class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        boolean flag=true;
        if(n<0){
            long m=n;
            return quick(1.0/x,-m);
        }else{
            return quick(x,n);
        }
    }

    public double quick(double x,long n){
        double res=1;
        while (n>0){
            if(n%2==1){
                res*=x;
            }
            x*=x;
            n/=2;
        }
        return res;
    }
}
