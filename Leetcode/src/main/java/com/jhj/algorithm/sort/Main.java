package com.jhj.algorithm.sort;

public class Main {
    public static void main(String[] args) {
        int[] ints = {5, 2, 3, 6, 1, 4, 9};
//        int[] ints1 = sort1(ints);
//        int[] ints1 = sort2(ints,0,ints.length-1);
        int[] ints1 = sort3(ints);
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
    //快速排序
    public static int[] sort2(int[] nums,int l,int r){
        if(l<r){
            int i,j,x;
            i=l;
            j=r;
            x=nums[i];
            while (i<j){
                while (i<j&&nums[j]>x){
                    j--;
                }
                if(i<j)
                    nums[i++]=nums[j];
                while (i<j&&nums[i]<x){
                    i++;
                }
                if(i<j)
                    nums[j--]=nums[i];
            }
            nums[i]=x;
            sort2(nums,l,i-1);
            sort2(nums,i+1,r);
        }
        return nums;
    }
    //插入排序
    public static int[] sort3(int[] nums){
        int i,j,k;
        for(i=1;i<nums.length;i++){
            for (j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    break;
                }
            }
            if(j!=i-1){
                int temp=nums[i];
                for(k=i-1;k>j;k--){
                    nums[k+1]=nums[k];
                }
                nums[k+1]=temp;
            }
        }
        return nums;
    }
}
