package com.Leetcode;

/**
 * Leetcode1894,找到需要补充粉笔的学生编号
 *
 */
public class LeetcodeDemo1894 {
    public static void main(String[] args) {
        int[] chalk = {3, 4, 1, 2};
        System.out.println(chalkReplacer(chalk, 25));
    }

    public static int chalkReplacer(int[] chalk, int k)
    {
        int n = chalk.length;
        long[] sum = new long[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + chalk[i - 1];

        k = (int) (k % sum[n]);
        int l = 1, r = n;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(sum[mid] <= k) l = mid;
            else r = mid - 1;
        }

        return sum[r] <= k ? r : r - 1;
    }

    public static int chalkReplacer1(int[] chalk, int k)
    {
        int idx = 0, n = chalk.length;
        long sum = 0;
        for(int t : chalk) sum += t;
        k = (int) (k % sum);
        for(int i = 0; i < n; i++)
        {
            k -= chalk[i];
            if(k < 0) return i;
        }
        return -1;
    }
}
