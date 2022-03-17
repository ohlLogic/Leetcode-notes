package com.Leetcode;

/**
 * Leetcode390,消除游戏
 * 约瑟夫环
 */
public class LeetcodeDemo390 {
    public int lastRemaining(int n)
    {
        return n == 1 ?  1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
