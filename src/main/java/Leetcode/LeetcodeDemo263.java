package com.Leetcode;

/**
 * Leetcode263,丑数
 */
public class LeetcodeDemo263 {
    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int n)
    {
        if(n <= 0) return false;
        boolean tag = true;
        while(n != 1)
        {
            if(n % 2 == 0) n /= 2;
            else if(n % 3 == 0) n /= 3;
            else if(n % 5 == 0) n /= 5;
            else
            {
                tag = !tag;
                break;
            }
        }
        return tag;
    }
}
