package com.Leetcode;

/**
 * Leetcode457,环形数组是否存在循环
 * 快慢指针
 */
public class LeetcodeDemo457 {
    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }

    //快慢指针
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == 0) continue;
            int slow = i, fast = next(nums, i);
            //判断方向相同(全正或者全负)
            while(nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0)
            {
                if(slow == fast)
                {
                    if(slow != next(nums, slow)) return true;
                    else break;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            int add = i;
            while(nums[add] * nums[next(nums, add)] > 0)
            {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }

        return false;
    }

    public static int next(int[] nums, int i)
    {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }
}
