package com.Leetcode;

/**
 * Leetcode1414,和为K的最少斐波那契数字数目
 * 贪心
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo1414 {
    public int findMinFibonacciNumbers(int k)
    {
        List<Integer> list = new ArrayList<>();
        //滚动数组，制表
        list.add(1);
        int l = 0, r = 1;
        while(r < k)
        {
            int cur = l + r;
            list.add(cur);
            l = r; r = cur;
        }

        //贪心，从后往前
        int ans = 0;
        for(int i = list.size() - 1; i >= 0 && k > 0; i--)
        {
            int cur = list.get(i);
            if(k - cur >= 0) {
                ans++;
                k -= cur;
            }

        }
        return ans;
    }
}
