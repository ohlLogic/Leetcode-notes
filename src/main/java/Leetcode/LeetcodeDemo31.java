package com.Leetcode;

/**
 * Leetcode31,下一个排列
 * 字典序排列：
 * [1,3,5,4,1]
 * //第一步： 从后往前找，找到第一个下降的位置，记为 k。注意k以后的位置是降序的。 在样例中就是找到 3；
 *
 * //第二步： 从 k + 1 往后找，找到最小的比 k 要大（必须是大于，不能等于）的数。 找到 4 ；这一步可以使用二分查找提高效率
 *
 * //第三步： 将两者交换。注意此时 k 以后的位置仍然是降序的。
 *
 * //第四步： 直接将 k 以后的部分(nums [k+1:n-1] ) 翻转（变为升序）。
 */
public class LeetcodeDemo31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void nextPermutation(int[] nums)
    {
        int n = nums.length;
        int k = n - 1;
        //while (k - 1 >= 0 && nums[k - 1] >= nums[k]) k--;
        for(int i = n - 1; i >= 0; i++)
        {
            if(nums[i - 1] < nums[i])
            {
                k = i;
                break;
            }
        }
        if(k == 0) reverse(nums, 0, n - 1);
        else
        {
            int u = k;
            while(u + 1 < n && nums[u + 1] > nums[k - 1]) u++;
            swap(nums, k - 1, u);
            reverse(nums, k, n - 1);
        }
    }
    public static void reverse(int[] nums, int a, int b)
    {
        int l = a, r = b;
        while(l < r)
        {
            swap(nums, l++, r--);
        }
    }
    public static void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
