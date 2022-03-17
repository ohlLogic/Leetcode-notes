package com.Leetcode;

/**
 * Leetcode540,有序数组中的单一元素
 */
public class LeetcodeDemo540 {
        //异或
    public int singleNonDuplicate(int[] nums)
    {
        int ans = 0;
        for(int i : nums) ans ^= i;
        return ans;
    }

    //二分
    public int singleNonDuplicate1(int[] nums)
    {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(mid % 2 == 0 && nums[mid] == nums[mid + 1]) l = mid + 2;
            else if(mid % 2 == 1 && nums[mid] == nums[mid - 1]) l = mid + 1;
            else r = mid;
        }
        return nums[r];
    }
}
