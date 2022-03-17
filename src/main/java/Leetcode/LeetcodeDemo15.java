package com.Leetcode;

/**
 * Leetcode15,三数之和
 * 双指针
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeDemo15 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0, j, k; i < nums.length; i++)
        {
            //排除重复情况
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            j = i + 1; k = nums.length - 1;
            while(j < k)
            {
                while(j > i + 1 && j < nums.length && nums[j] == nums[j - 1]) j++;
                if(j >= k) break;
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k]));
                else if(sum > 0) k--;
                else if(sum < 0) j++;
            }
        }
        return res;
    }
}
