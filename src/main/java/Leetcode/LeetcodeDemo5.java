package com.Leetcode;

public class LeetcodeDemo5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("cbbd"));
    }

    //暴力法，时间复杂度O(n^2)
    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int max = 0;
        String temp = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
           int j = i + 1;
           while(j < s.length()) {
               if (checkString(s.substring(i, j + 1)) && (max < j - i + 1)) {
                   max = j - i + 1;
                   temp = s.substring(i, j + 1);
               }
               j++;
           }
        }
        return temp;
    }

    public static boolean checkString(String s) {
        StringBuilder sb = new StringBuilder();
        return s.equals(sb.append(s).reverse().toString());
    }


    //中心扩散法
    public static String longestPalindrome1(String s)
    {
        int cur = 0, l = cur, r = cur;
        int max = 0, maxstart = 0;
        while(cur < s.length())
        {
            while((--l) >= 0 && s.charAt(l) == s.charAt(cur));
            while((++r) <= s.length() - 1 && s.charAt(r) == s.charAt(cur));
            while(l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r))
            {
                l--;
                r++;
            }
            if(max < r - l - 1)
            {
                max = r - l -1;
                maxstart = ++l;
            }
            cur++;
            l = cur;
            r = cur;
        }

        return s.substring(maxstart, maxstart + max);
    }


    //动态规划
    public static String longestPalindrome2(String s)
    {
        if(s == null || s.length() == 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        int maxstart = 0, max = 1;

        //状态初始化
        for(int l = 0; l < s.length(); l++) dp[l][l] = true;

        //状态转移
        for(int r = 1; r < s.length(); r++)
        {
            for(int l = 0; l < r; l++)
            {
                //判断是否是连续相同字符，或者上一个子串是否为回文串
                if(s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1]))
                {
                    dp[l][r] = true;
                    if(max < r - l + 1)
                    {
                        max = r - l + 1;
                        maxstart = l;
                    }
                }

            }
        }

        return s.substring(maxstart, maxstart + max);
    }
}
