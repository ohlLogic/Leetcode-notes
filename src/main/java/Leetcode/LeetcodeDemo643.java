package com.Leetcode;

/**
 * Leetcode643,子数组最大平均数1
 */
public class LeetcodeDemo643 {
    public static void main(String[] args) {
        int[] nums = {4,2,1,3,3};
        System.out.println(findMaxAverage(nums, 2));
    }

    //前缀和
    public static double findMaxAverage(int[] nums, int k)
    {
        int n = nums.length;
        double max = Integer.MIN_VALUE;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        if(n == k) return (double) sum[n] / n;
        for(int i = k; i <= n; i++)
        {
            int tt = sum[i] - sum[i - k];
            max = Math.max((double) tt / k, max);
            System.out.println(max);
        }
        return max;
    }

    //滑动窗口
    public static double findMaxAverage1(int[] nums, int k)
    {
        double res = 0, sum = 0;
        for(int i = 0; i < k; i++) sum += nums[i];
        res = sum / k;
        for(int i = k; i < nums.length; i++)
        {
            sum = sum + nums[i] - nums[i - k];
            res = Math.max(res, sum / k);
        }
        return res;
    }
}
