package com.Leetcode;

/**
 * Leetcode119,杨辉三角2
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex)
    {
        List<List<Integer>> list = new ArrayList<>();
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        dp[0][0] = 1;
        list.add(new ArrayList<>(){{add(dp[0][0]);}});
        if(rowIndex == 0) return list.get(0);

        for(int i = 1; i <= rowIndex; i++)
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
        return list.get(rowIndex);
    }
}
