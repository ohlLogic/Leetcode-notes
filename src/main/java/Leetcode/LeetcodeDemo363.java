package com.Leetcode;

/**
 * Leetcode363,矩形区域不超过k 的最大数值和
 * 二分+前缀和
 */

import java.util.Arrays;
import java.util.TreeSet;

public class LeetcodeDemo363 {
    public static void main(String[] args) {

    }

    public static int maxSumSubmatrix(int[][] matrix, int k)
    {
        int m = matrix.length, n = matrix[0].length;
        //前缀和数组sum
        int[][] sum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int res = Integer.MIN_VALUE;
        //遍历子矩阵的上边界
        for(int top = 1; top <= m; top++)
        {
            for(int bot = top; bot <= m; bot++)
            {
                //使用有序集合TreeSet维护所有遍历到的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                //遍历子矩阵的右边界
                for(int r = 1; r <= n; r++)
                {
                    //通过前缀和计算right
                    int right = sum[bot][r] - sum[top - 1][r];
                    //通过二分找left
                    Integer left = ts.ceiling(right - k);
                    if(left != null) res = Math.max(res, right - left);
                    //将遍历过的right加到有序集合
                    ts.add(right);
                }
            }
        }
        return res;
    }

    //如果n可能比m小的情况，优化二分过程，同时优化前缀和的空间复杂度
    public static int maxSumSubmatrix1(int[][] matrix, int k)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean isRight = n > m;
        int[] sum = isRight ? new int[n + 1] : new int[m + 1];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= (isRight ? m : n); i++)
        {
            Arrays.fill(sum, 0);
            for(int j = i; j <= (isRight ? m : n); j++)
            {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for(int fixed = 1; fixed <= (isRight ? n : m); fixed++)
                {
                    sum[fixed] += isRight ? matrix[j - 1][fixed - 1] : matrix[fixed - 1][j - 1];
                    a += sum[fixed];
                    Integer b = ts.ceiling(a - k);
                    if(b != null) res = Math.max(res, a - b);
                    ts.add(a);
                }
            }
        }
        return res;
    }
}
