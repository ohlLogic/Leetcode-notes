package com.Leetcode;

/**
 * Leetcode1614,括号的最大嵌套深度
 * 模拟
 */
public class LeetcodeDemo1614 {
    public int maxDepth(String s)
    {
        int ans = 0, n = s.length();
        for(int i = 0, cnt = 0; i < n; i++)
        {
            if(s.charAt(i) == '(') cnt++;
            else if(s.charAt(i) == ')') cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
