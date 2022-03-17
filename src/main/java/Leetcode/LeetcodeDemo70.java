package com.Leetcode;

/**
 * Leetcode70:爬楼梯，每次可以爬1个或2个台阶，有多少种方法可以爬到n阶楼梯。
 */
public class LeetcodeDemo70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs2(3));
    }


    /**
     * 动态规划：这里设置dp数组，其中dp[k]代表当前第k个楼梯方案
     * dp[k] = dp[k - 1] + dp[k - 2]构成，意思为第k个楼梯方案可以由第k-1个楼梯走一步，和第k-2
     * 个楼梯方案走一步实现；
     * 初始化为防止越界，设置dp[n + 1], dp[0] = 1, dp[1] = 1;
     * @param n
     * @return dp[n]
     */
    public static int climbStairs(int n)
    {
        int[] dp = new int[n + 1];

        //dp数组初始化
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 记忆化递归
     * @param n
     * @return
     */
    public static int climbStairs1(int n)
    {
        int[] memo = new int[n + 1];
        return climbStrairsMemo(n, memo);
    }

    public static int climbStrairsMemo(int n, int[] memo) {
        if(memo[n] > 0) return memo[n];

        if(n == 1) return 1;
        else if(n == 0) return 1;
        else{
            memo[n] = climbStrairsMemo(n - 1, memo) + climbStrairsMemo(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 滚动数组
     */

    public static int climbStairs2(int n)
    {
        int r = 0, p = 1;
        int l = 0;
        for(int i = 1; i <= n; i++)
        {
            l = r + p;
            r = p;
            p = l;
        }
        return l;
    }
}
