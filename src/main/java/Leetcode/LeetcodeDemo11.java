package com.Leetcode;

/**
 * Leetcode11,盛水最多的容器
 * 双指针+贪心
 */
public class LeetcodeDemo11 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(nums));
    }

    //暴力，超时
    public static int maxArea(int[] height)
    {
        int max = 0, n = height.length;
        for(int i = 0; i < n; i++)
        {
            int l = 0, r = n - 1;

            if(i == 0){
                while(l < r)
                {
                    int h = Math.min(height[i], height[r]);
                    max = Math.max(h * (r - i), max);
                    r--;
                }
            }
            else if(i == n - 1)
            {
                while(l < r)
                {
                    int h = Math.min(height[i], height[l]);
                    max = Math.max(max, h *(i - l));
                    l++;
                }
            }
            else
            {
                while(l < r)
                {
                    int h = Math.min(height[i], height[r]);
                    max = Math.max(h * (r - i), max);
                    r--;
                    h = Math.min(height[i], height[l]);
                    max = Math.max(max, h *(i - l));
                    l++;
                }

            }
        }
        return max;
    }

    //双指针+贪心
    public static int maxArea1(int[] height)
    {
        int n = height.length;
        int l = 0, r = n - 1;
        int res = 0;
        while(l < r)
        {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }
}
