package com.Leetcode;

/**
 * Leetcode992,k个不同整数的子数组
 * 滑动窗口
 */
public class LeetcodeDemo992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(subarrayWithDistinct(nums, 2));
    }

    public static int subarrayWithDistinct(int[] nums, int k)
    {
        int n = nums.length;
        int res = 0;
        int[] a1 = new int[n], a2 = new int[n];
        find(a1, nums, k);
        find(a2, nums, k - 1);
        for(int i = 0; i < n; i++) res += a2[i] - a1[i];
        return res;
    }

    //找到距离当前nums[i]最远的k个不同数字
    public static void find(int[] a, int[] nums, int k)
    {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for(int i = 0, j = 0, sum = 0; i < n; i++)
        {
            cnt[nums[i]]++;
            if(cnt[nums[i]] == 1) sum++;
            while (sum > k) {
                cnt[nums[j]]--;
                if(cnt[nums[j]] == 0) sum--;
                j++;
            }
            a[i] = j;
        }
    }
}
