package com.Leetcode;

/**
 * Leetcode1423,可获得的最大点数
 * 滑动窗口
 */
public class LeetcodeDemo1423 {
    public static void main(String[] args) {
        int[] nums = {100,40,17,9,73,75};
        System.out.println(maxScore(nums, 3));
    }

    public static int maxScore(int[] cardPoints, int k)
    {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < k; i++) sum += cardPoints[n - 1 - i];
        int max = sum;
        int r = 0, l = n - k;
        while(r < k)
        {
            sum += cardPoints[r++];
            sum -= cardPoints[l++];
            max = Math.max(max, sum);
        }
        return max;
    }
}
