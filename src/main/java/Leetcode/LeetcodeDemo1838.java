package com.Leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class LeetcodeDemo1838 {
    public static void main(String[] args) {
        int[] nums = {3,9,6};
        System.out.println(maxFrequency(nums, 2));
        System.out.println(maxFrequency1(nums, 2));
    }

    //超时，暴力
    public static int maxFrequency(int[] nums, int k)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        int res = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(r < n)
        {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            int sum = check(nums, map, l, r);
            while(sum > k)
            {
                l++;
                sum = check(nums, map, l, r);
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static int check(int[] nums, TreeMap<Integer, Integer> map, int l, int r)
    {
        int sum = 0;
        for(int i = l; i <= r; i++)
        {
            sum += map.lastKey() - nums[i];
        }
        return sum;
    }

    //柱状图非常好理解，滑动窗口
    public static int maxFrequency1(int[] nums, int k)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 1;
        int cost = 0;
        int res = 1;
        while(r < n)
        {
            cost += (nums[r] - nums[r - 1]) * (r - l);
            while(cost > k)
            {
                cost -= nums[r] - nums[l];
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
