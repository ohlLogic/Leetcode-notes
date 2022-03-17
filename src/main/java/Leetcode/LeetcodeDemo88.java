package com.Leetcode;

public class LeetcodeDemo88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge1(nums1, 3, nums2, nums2.length);

        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int[] temp = new int[m + n];
        int i = 0, j = 0;
        int cur;
        while(i < m || j < n)
        {
            if(i == m) cur = nums2[j++];
            else if(j == n) cur = nums1[i++];
            else if(nums1[i] <= nums2[j]) cur = nums1[i++];
            else  cur = nums2[j++];
            temp[i + j - 1] = cur;
        }

        for(int k = 0; k < m + n; k++)
        {
            nums1[k] = temp[k];
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n)
    {
        /**
         * nums1初始长度为m + n
         */

        int i = m - 1, j = n - 1;
        while(i >= 0 || j >= 0)
        {
            if(i == -1) nums1[i + j + 1] = nums2[j--];
            else if(j == -1) nums1[i + j + 1] = nums1[i--];
            else if(nums1[i] >= nums2[j]) nums1[i + j + 1] = nums1[i--];
            else nums1[i + j + 1] = nums2[j--];
        }
    }

}
