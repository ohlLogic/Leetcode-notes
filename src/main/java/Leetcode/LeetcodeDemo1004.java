package com.Leetcode;

/**
 * Leetcode1004,最大连续1的个数3
 * 滑动窗口
 */
public class LeetcodeDemo1004 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1};
        System.out.println(longestOnes(nums, 4));
    }

    //滑动窗口
    public static int longestOnes(int[] nums, int k)
    {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, res = 0, cnt = 0;
        while(r < n)
        {
            sum = r - l + 1;
            if(nums[r] == 0) cnt++;
            if(cnt == k) res = Math.max(res, sum);
            while(cnt > k) {
                if(nums[l] == 0) cnt--;
                sum--;
                l++;
            }
            r++;
        }
        return cnt < k ? Math.max(res, sum) : res;
    }
}
