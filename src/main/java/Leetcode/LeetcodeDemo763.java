package com.Leetcode;

/**
 * LeetcodeDemo763,划分字母区间
 * 贪心
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo763 {
    public List<Integer> partitionLabels(String s)
    {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int[] last = new int[26];
        //记录s字符串每个字符最后一个位置
        for(int i = 0; i < n; i++) last[s.charAt(i) - 'a'] = i;

        int start = 0, end = 0;
        for(int i = 0; i < n; i++)
        {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end)
            {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
