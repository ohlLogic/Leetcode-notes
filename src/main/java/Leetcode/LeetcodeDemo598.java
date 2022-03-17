package com.Leetcode;

/**
 * Leetcode598,范围求和2
 *
 */
public class LeetcodeDemo598 {
    public int maxCount(int m, int n, int[][] ops)
    {
        if(ops.length == 0) return m * n;
        int leftmin = Integer.MAX_VALUE, rightmin = Integer.MAX_VALUE;
        for(int i = 0; i < ops.length; i++)
        {
            int curleft = ops[i][0], curright = ops[i][1];
            leftmin = Math.min(curleft, leftmin);
            rightmin = Math.min(curright, rightmin);
        }
        return leftmin * rightmin;
    }
}
