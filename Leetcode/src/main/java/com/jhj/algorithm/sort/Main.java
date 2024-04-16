package com.jhj.algorithm.sort;

public class Main {
    public static void main(String[] args) {
        int[] ints = {5, 2, 3, 6, 1, 4, 9};
        int[] ints1 = sort1(ints);
        for(int i=0;i<ints1.length;i++){
            System.out.println(ints1[i]);
        }

    }

    //冒泡排序
    public static int[] sort1(int[] nums){
        for(int j=nums.length-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(nums[i]>nums[i+1]){
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                }
            }
        }
        return nums;
    }
}
