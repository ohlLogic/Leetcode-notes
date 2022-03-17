package com.Leetcode;

/**
 * Leetcode458,可怜的小猪
 * 信息论
 */
public class LeetcodeDemo458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest)
    {
        int k = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(k + 1));
    }


    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest)
    {
        //一只猪最多可以试验的桶数
        int k = minutesToTest / minutesToDie + 1;
        int cnt = 0;
        while(Math.pow(k, cnt) < buckets)
        {
            cnt++;
        }
        return cnt;
    }
}
