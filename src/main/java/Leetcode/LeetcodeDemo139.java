package com.Leetcode;

/**
 * Leetcode139,单词拆分
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetcodeDemo139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    /**
     * 动态规划
     * d[i]表示字符串前i个字符组成的字符串是否可以被分解为字典中的单词
     * 因此需要枚举s[0,...,i-1]中的分割点j，分解为s[0,...,j-1],s[j,...,i-1]
     * 判断这两部分是否存在于字典中
     *
     * 初始状态
     * d[0] = true;
     *
     * 状态转移
     *dp[i] = dp[j] && check(s[j,...,i-1])
     */
    public static boolean wordBreak(String s, List<String> wordDict)
    {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < wordDict.size(); i++) map.put(wordDict.get(i), i);

        //初始状态
        dp[0] = true;
        for(int i = 1; i <= n; i++)
        {
            int j = i - 1;
            while(j >= 0)
            {
                if(dp[j] && check(s.substring(j, i), map)) dp[i] = true;
                j--;
            }
        }
        return dp[n];
    }

    public static boolean check(String s, HashMap<String, Integer> map)
    {
        return map.containsKey(s);
    }

}
