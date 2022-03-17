package com.Leetcode;

/**
 * Leetcode1791,找出星型图的中心节点
 */
public class LeetcodeDemo1791 {
    public int findCenter(int[][] edges)
    {
        int a = edges[0][0], b = edges[0][1];
        if(a == edges[1][0] || a == edges[1][1]) return a;
        return b;
    }
}
