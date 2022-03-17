package com.Leetcode;

/**
 *Leetcode213,打家劫舍2
 * 因为房屋是环形结构，因此偷取第一家就不能偷取最后一家；
 * 如果偷了第一家，那么偷窃房屋的范围为1 ~ n - 1;
 * 如果偷了最后一家，那么偷窃房屋的范围为 2 ~ n
 */
public class LeetcodeDemo213 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob1(nums));
    }


    public static int rob1(int[] nums)
    {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(getMax(nums,0, nums.length - 2), getMax(nums,1, nums.length - 1));
    }
    public static int getMax(int[] nums, int l, int r)
    {
        //l,r代表要偷取的范围
        int x1 = nums[l], x2 = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++)
        {
            //滚动数组
            int temp = x2;
            x2 = Math.max(x1 + nums[i], x2);
            x1 = temp;
        }
        return x2;
    }
}
