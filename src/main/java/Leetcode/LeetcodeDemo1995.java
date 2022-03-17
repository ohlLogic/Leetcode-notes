package com.Leetcode;

/**
 * Leetcode1995,统计特殊四元组
 * 哈希表
 */
public class LeetcodeDemo1995 {
    //暴力
    public int countQuadruplets(int[] nums)
    {
        int n = nums.length, ans = 0;

        for(int a = 0; a < n; a++)
        {
            for(int b = a + 1; b < n; b++)
            {
                for(int c = b + 1; c < n; c++)
                {
                    for(int d = c + 1; d < n; d++)
                    {
                        if(nums[a] + nums[b] + nums[c] == nums[d]) ans++;
                    }
                }
            }
        }
        return ans;
    }


    //哈希表，枚举b
    public int countQuadruplets1(int[] nums)
    {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];

        for(int b = n - 3; b >= 1; b--)
        {
            for(int d = b + 2; d < n; d++) cnt[nums[d] - nums[b + 1] + 200]++;
            for(int a = 0; a < b; a++) ans += cnt[nums[a] + nums[b] + 200];
        }
        return ans;
    }
}
