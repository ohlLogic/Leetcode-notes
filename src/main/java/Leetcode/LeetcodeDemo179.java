package com.Leetcode;

/**
 * Leetcode179,最大数
 * 贪心
 * 证明较难
 */

import java.util.Arrays;

public class LeetcodeDemo179 {
    public String largestNumber(int[] nums)
    {
        int n = nums.length;
        String[] ss = new String[n];
        for(int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a;
            //字典排序
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : ss) sb.append(s);
        int k = 0;
        while(k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
