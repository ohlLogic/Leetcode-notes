package com.Leetcode;

/**
 * Leetcode1447,最简分数
 * 数学
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo1447 {
    public List<String> simplifiedFractions(int n)
    {
        List<String> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++) //分母
        {
            for(int j = 1; j < i; j++) //分子
            {
                if(gcd(i, j) == 1) ans.add(String.valueOf(j) + "/" + String.valueOf(i));
            }
        }
        return ans;
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
