package com.Leetcode;

/**
 * Leetcode633,平方数之和
 * 双指针
 */
public class LeetcodeDemo633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }

    public static boolean judgeSquareSum(int c)
    {
        int max = (int) Math.sqrt(c);
        for(int a = 0; a <= max; a++)
        {
            int b = (int) Math.sqrt(c - a * a);
            if(a * a + b * b == c) return true;
        }
        return false;
    }

    public static boolean judgeSquareSum1(int c)
    {
        long a = 0, b = (long)Math.sqrt(c);
        while(a <= b)
        {
            long cur = a * a + b * b;
            if(cur == c) return true;
            else if(cur > c) b--;
            else a++;
        }
        return false;
    }
}
