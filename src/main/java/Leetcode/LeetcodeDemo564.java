package com.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode564,寻找最近的回文数
 * 贪心
 */
public class LeetcodeDemo564 {
    public String nearestPalindromic(String s)
    {
        int n = s.length();
        //将s转为long类型数据
        long cur = Long.parseLong(s);

        Set<Long> set = new HashSet<>();
        //将边界值考虑进去，因为会出现abcde形式，abc=999 or abc=100情况
        set.add((long) Math.pow(10, n - 1) - 1);
        set.add((long) Math.pow(10, n) + 1);

        //取前半段
        long t = Long.parseLong(s.substring(0, (n + 1) / 2));

        for(long i = t - 1; i <= t + 1; i++)
        {
            long temp = -1;
            //字符串s长度n
            if(n % 2 == 0) temp = getNum(i, true);
            else temp = getNum(i, false);
            if(temp != cur) set.add(temp);
        }

        long ans = -1;
        for (long i : set) {
            if (ans == -1) ans = i;
            else if (Math.abs(i - cur) < Math.abs(ans - cur)) ans = i;
            else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) ans = i;
        }
        return String.valueOf(ans);
    }

    long getNum(long k, boolean isEven) {
        //偶数ab，sb中构造为abba；奇数abc，sb中构造为abcba
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int idx = isEven ? sb.length() - 1 : sb.length() - 2;
        while (idx >= 0) sb.append(sb.charAt(idx--));
        return Long.parseLong(sb.toString());
    }

}
