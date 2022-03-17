package com.Leetcode;

/**
 * Leetcode611,有效三角形的个数
 * 双指针
 */

import java.util.Arrays;

public class LeetcodeDemo611 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1};
        System.out.println(triangleNumber(nums));
    }

    //双指针+二分
    public static int triangleNumber(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = i - 1; j >= 0; j--)
            {
                int l = 0, r = j - 1;
                while(l < r)
                {
                    int mid = l + r >> 1;
                    if(nums[mid] + nums[j] > nums[i]) r = mid;
                    else l = mid + 1;
                }
                if(nums[l] + nums[j] > nums[i]) res += j - l;
            }
        }
        return res;
    }

    //排序+双指针
    public static int triangleNumber1(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);

        int res = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i - 1, k = 0; k < j; j--)
            {
                while(k < j && nums[k] + nums[j] <= nums[i]) k++;
                res += j - k;
            }
        }
        return res;
    }
}
