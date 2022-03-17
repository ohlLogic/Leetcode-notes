package com.Leetcode;

/**
 * Leetcode118,杨辉三角
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo118 {
    public static void main(String[] args) {
        System.out.println(generate1(5));
    }

    public static int Caln(int n, int k) {
        int sum1 = 1, sum2 = 1, sum3 = 1;
        for (int i = 0; i < n; i++) sum1 *= (n - i);
        for (int j = 0; j < k; j++) sum2 *= (k - j);
        for (int i = 0; i < n - k; i++) sum3 *= (n - k - i);
        return sum1 / sum2 / sum3;
    }

    //数学，组合数公式
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++)
        {
            List<Integer> ll = new ArrayList<>();
            for(int j = 0; j <= i; j++) ll.add(Caln(i, j));
            list.add(ll);
        }
        return list;
    }

    //动态规划
    public static List<List<Integer>> generate1(int numRows)
    {
        List<List<Integer>> list = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        list.add(new ArrayList<>(){{add(dp[0][0]);}});
        if(numRows == 1) return list;

        for(int i = 1; i < numRows; i++)
        {
            List<Integer> ll = new ArrayList<>();
            dp[i][0] = 1;
            ll.add(dp[i][0]);
            for(int j = 1; j < i; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                ll.add(dp[i][j]);
            }
            dp[i][i] = 1;
            ll.add(dp[i][i]);
            list.add(ll);
        }
        return list;
    }

}
