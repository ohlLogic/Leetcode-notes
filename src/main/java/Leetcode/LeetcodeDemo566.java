package com.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetcodeDemo566 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}};
        maxtixPeshape(mat, 1, 0);
    }

    //模拟
    public static int[][] maxtixPeshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length < r * c) return mat;

        Queue<Integer> qq = new ArrayDeque<>();
        int[][] tt = r == 1 ? new int[r][mat.length * mat[0].length] : new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                qq.add(mat[i][j]);
            }
        }

        int bb = r == 1 ? mat.length * mat[0].length : c;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < bb; j++) {
                tt[i][j] = qq.poll();
            }
        }
        return tt;
    }

    //映射,将二维数组映射到一维,NB
    public static int[][] matrixReshapa(int[][] nums, int r, int c)
    {
        int m = nums.length;
        int n = nums[0].length;
        if(m * n != r * c) return nums;

        int[][] ans = new int[r][c];
        for(int x = 0; x < m * n; x++)
        {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
