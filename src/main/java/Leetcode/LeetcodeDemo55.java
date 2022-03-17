package com.Leetcode;

/**
 * Leetcode55, 跳跃游戏
 */
public class LeetcodeDemo55 {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump1(nums));
    }

    //动态规划
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        if (n == 2) return nums[0] >= 1 ? true : false;


        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        if (nums[0] >= 1) dp[1] = true;

        for (int i = 2; i < n; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
                j--;
            }
        }
        return dp[n - 1];
    }

    /**
     * 贪心算法：
     * 如果有个位置为x，它本身可到达;那么只有目标y <= x + nums[x],那么y一定可到达;
     * 依次遍历数组维护一个最远可到达的位置max，如果对于遍历到的当前位置x，如果 x <= max
     * 返回true,否则返回false
     */
    public static boolean canJump1(int[] nums)
    {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; ++i)
        {
            //当前位置可到达
            if(i <= max)
            {
                max = Math.max(max, i + nums[i]);

                if(max >= n - 1) return true;
            }
        }
        return false;
    }



}
