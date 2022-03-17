package com.Leetcode;

/**
 * Leetcode275,H指数2
 * 二分
 *
 */
public class LeetcodeDemo275 {
    public static void main(String[] args) {

    }

    public static int hIndex(int[] citations)
    {
        int n = citations.length;
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(citations[mid] >= n - mid) r = mid;
            else l = mid + 1;
        }
        return citations[l] >= n - l ? n - l : 0;
    }
}
