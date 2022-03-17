package com.Leetcode;

/**
 * Leetcode852,山脉数组的峰顶索引
 */
public class LeetcodeDemo852 {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(peakIndexInMountainArray1(nums));
    }

    public static int peakIndexInMountainArray(int[] arr)
    {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++)
        {
            if(arr[i] > arr[i + 1]) return i;
        }
        return 0;
    }

    //二分
    public static int peakIndexInMountainArray1(int[] arr)
    {
        int n = arr.length;
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(arr[mid - 1] < arr[mid]) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
