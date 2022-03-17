package com.Leetcode;

/**
 * Leetcode1342,将数字变成0的操作次数
 * 模拟
 */
public class LeetcodeDemo1342 {
    public int numberOfSteps(int num)
    {
        int ans = 0;
        while(num != 0)
        {
            if(num % 2 == 0) num /= 2;
            else num -= 1;
            ans++;
        }
        return ans;
    }
}
