package com.Leetcode;

public class LeetcodeDemo441 {
    public static void main(String[] args) {

    }

    //数学
    public static int arrangeCoins(int n)
    {
        return (int) ((Math.sqrt(1 + 8.0 * n) -  1) / 2);
    }

    //二分
    public static int arrangeCoins1(int n)
    {
        long l = 1, r = n;
        while(l < r)
        {
            long mid = l + r + 1 >> 1;
            if(mid * (mid + 1) / 2 <= n) l = mid;
            else r = mid -  1;
        }
        return (int) r;
    }
}
