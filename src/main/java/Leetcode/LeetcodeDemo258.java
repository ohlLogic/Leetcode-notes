package com.Leetcode;

/**
 * Leetcode258,各位相加
 */
public class LeetcodeDemo258 {
    public int addDigits(int num)
    {
        int res = num;
        while(res >= 10)
        {
            int r = num % 10;
            num /= 10;
            res = r + num;
            num = res;
        }
        return res;
    }

    /**
     * 数学：
     * 1.能够被9整除的数，个位上的数字加起来也能被9整除，累加起来最终就是9
     * 2.不能被9整除的数，各位上数字相加，结果对9取模和初始数对9取模，结果是一样
     */

    public int addDigits1(int num)
    {
        return (num - 1) % 9 + 1;
    }
}
