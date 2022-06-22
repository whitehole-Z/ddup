package com.learn.algorithms;

public class SortAlgorithms {
    public static void quickSort(int[] nums,int l,int r){
        if(l>=r) return;
//        int index = (int)((r-l+1) * Math.random());
        int index = partition(nums,l,r);
        quickSort(nums,l,index-1);
        quickSort(nums,index+1,r);
    }

    public static int partition(int[] nums,int l,int r){
        int pivot = l + (int)((r-l) * Math.random());
        swap(nums,r,pivot);
        int key = nums[r];
        int j = l;      //左侧的都是比key小的
        for (int i = l; i < r-1; i++) {
            if(nums[i] <=key){
                swap(nums,i,j);
                j++;
            }
        }
        swap(nums,j,r);
        return j;
    }

    public static void mergeSort(int[] nums,int l,int r,int[] temp){
        if(l>=r) return;
        int mid = l + (r-l)/2;
        mergeSort(nums,l,mid,temp);
        mergeSort(nums,mid+1,r,temp);
        int a = l,b = mid+1,index = l;
        while (index<=r){
            if(b>r || (a<=mid && nums[a]<=nums[b])){
                temp[index++] = nums[a++];
            }else{
                temp[index++] = nums[b++];
            }
        }
        for (int i = l; i <=r ; i++) {
            nums[i] = temp[i];
        }
    }

    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }
            }
        }
    }












    public static  void swap(int[] nums,int l,int r){
        if(l!=r){
            nums[l]= nums[l] ^ nums[r];
            nums[r]= nums[l] ^ nums[r];
            nums[l]= nums[l] ^ nums[r];
        }
    }
}
