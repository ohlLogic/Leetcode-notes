package com.Leetcode;

/**
 * Leetcode53,最大子序和
 * 动态规划
 * dp[i]表示以i结束的子序列最大值
 * 初始状态：dp[0] = nums[0]
 * 状态转移：dp[i] = max(dp[i - 1] + nums[i], nums[i])表示如果当前位置加上上一个位置的最大值
 * 和当前位置的值比较，取最大值
 * 用max来维护dp数组的最大值，表示最大的子序列和
 */
public class LeetcodeDemo53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    //时间复杂度O(n),空间复杂度O(n)
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n + 1];

        //初始状态
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return max;
    }

    //空间复杂度优化,类似于滚动数组，用pre维护dp[i]相对的dp[i - 1]
    public static int maxSubArray1(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

    //分治法
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) return new Status(a[l], a[l], a[l], a[l]);
        int m = l + r >> 1;
        Status lSub = getInfo(a, 1, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r)
    {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
