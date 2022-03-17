package com.Leetcode;

/**
 * Leetcode285,最大连续1的个数
 * 双指针
 */
public class LeetcodeDemo485 {
    public static void main(String[] args) {
        int[] nums ={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums)
    {
        int n = nums.length;
        int l = 0, r = 0;
        while(r < n && nums[r] == 0) r++;
        if(r == n) return 0;
        l = r;

        int res = r - l + 1;

        while(r < n)
        {
            while(r + 1 < n && nums[r + 1] == 1) r++;
            res = Math.max(res, r - l + 1);
            if(r == n - 1) break;
            while(r + 1 < n && nums[r + 1] == 0) r++;
            l = r + 1;
        }

        return res;
    }
}
