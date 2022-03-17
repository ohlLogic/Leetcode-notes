package com.Leetcode;

/**
 * Leetcode278，第一个错误版本
 * 二分法
 */
public class LeetcodeDemo278 {
    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n)
    {
        int l = 1, r = n;
        while(l < r)
        {
            int mid = l + (r - l) / 2;
            if(isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    public static boolean isBadVersion(int r)
    {
        return true;
    }
}
