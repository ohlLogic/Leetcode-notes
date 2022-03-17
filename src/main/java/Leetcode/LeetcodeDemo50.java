package com.Leetcode;

/**
 * Leetcode50, Pow(x,n)
 * 快速幂
 */
public class LeetcodeDemo50 {
    public double myPow(double x, int n)
    {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, - N);
    }
    //递归
    public double quickMul(double x, long N)
    {
        if(N == 0) return 1.0;

        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double quickMul1(double x, long N)
    {
        double res = 1.0;
        //贡献的初始值x
        double t = x;
        while(N > 0)
        {
            if(N % 2 == 1)  res *= t;
            t *= t;
            N /= 2;
        }
        return res;
    }
}
