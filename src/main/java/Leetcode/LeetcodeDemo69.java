package com.Leetcode;

/**
 * Leetcode69: 计算x的平方根，如果是小数则保留整数部分，舍去小数部分。
 */
public class LeetcodeDemo69 {
    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(5));
        System.out.println(mySqrt1(6));
    }

    public static int mySqrt(int x)
    {
        return (int) Math.sqrt(x);
    }

    //二分法
    public static int mySqrt1(int x)
    {
        int l = 0, r = x;
        int mid = l + r >> 1;
        while(l <= r)
        {
            mid = l + r >> 1;
            if((long)mid * mid == x) return mid;
            else if((long)mid * mid < x) l = mid + 1;
            else r = mid - 1;
        }

        if(mid * mid < x) return mid;
        return mid - 1;
    }


    //牛顿迭代法
    public static int mySqrt2(int x)
    {
        if(x == 0) return 0;

        //x0代表牛顿迭代法初始值，C代表要计算的x的平方根
        double x0 = x, C = x;
        while(true)
        {
            double x1 = 0.5 * (x0 + C / x0);
            if(Math.abs(x0 - x1) < 1e-7) break;
            x0 = x1;
        }

        return (int) x0;
    }
}
