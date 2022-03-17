package com.Leetcode;

/**
 * Leetcode18,四数之和
 * 双指针
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LeetcodeDemo18 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(fourSum(nums, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);
        for(int i = 0; i < n; i++)
        {
            //第一个数字去重
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++)
            {
                //第二个数字去重
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1, p = n - 1;
                while(k < p)
                {
                    //第三个数字去重
                    while(k > j + 1 && k < n && nums[k] == nums[k - 1]) k++;
                    if(k >= p) break;

                    int sum = nums[i] + nums[j] + nums[k] + nums[p];
                    if(sum == target) res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[p]));
                    else if(sum > target) p--;
                    else if(sum < target) k++;
                }
            }
        }
        return res;
    }
}
