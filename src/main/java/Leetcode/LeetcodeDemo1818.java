package com.Leetcode;

/**
 * Leetcode1818,绝对差值和
 * 二分
 */

import java.util.Arrays;

public class LeetcodeDemo1818 {
    public static void main(String[] args) {

    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2)
    {
        int mod = (int)1e9 + 7;
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long sum = 0, max = 0;
        for(int i = 0; i < n; i++)
        {
            int a = nums1[i], b = nums2[i];
            if(a == b) continue;
            int x = Math.abs(a - b);
            sum += x;
            int l = 0, r = n - 1;
            while(l < r)
            {
                int mid = l + r + 1 >> 1;
                if(sorted[mid] <= b) l = mid;
                else r = mid - 1;
            }
            int nd = Math.abs(sorted[r] - b);
            if(r + 1 < n) nd = Math.min(nd, Math.abs(sorted[r + 1] - b));
            if(nd < x) max = Math.max(max, x - nd);

        }
        return (int)((sum - max) % mod);
    }
}
