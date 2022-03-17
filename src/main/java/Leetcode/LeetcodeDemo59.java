package com.Leetcode;

/**
 * Leetcode59,螺旋矩阵2
 * 模拟
 */
public class LeetcodeDemo59 {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] re : res) {
            for (int i : re) {
                System.out.println(i);
            }
        }
    }
    //按照方向进行模拟
    public static int[][] generateMatrix(int n)
    {
        int[][] res = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int row = 0, col = 0, dIndex = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i = 1; i <= n * n; i++)
        {
            res[row][col] = i;
            visited[row][col] = true;
            int nextrow = row + direction[dIndex][0], nextcol = col + direction[dIndex][1];
            if(nextrow < 0 || nextrow >= n || nextcol < 0 || nextcol >= n || visited[nextrow][nextcol]) dIndex = (dIndex + 1) % 4;
            row += direction[dIndex][0];
            col += direction[dIndex][1];
        }
        return res;
    }

    //按照形状进行模拟
    public static int[][] generateMatrix1(int n)
    {
        int[][] res = new int[n][n];
        circle(0, 0, n - 1, n - 1, 1, res);
        return res;
    }

    public static void circle(int x1, int y1, int x2, int y2, int start, int[][] res) {
        if(x2 < x1 || y2 < y1) return;
        //矩阵终点
        if(x1 == x2)
        {
            res[x1][y1] = start;
            return;
        }
        int val = start;
        for(int i = y1; i < y2; i++) res[x1][i] = val++;
        for(int i = x1; i < x2; i++) res[i][y2] = val++;
        for(int i = y2; i > y1; i--) res[x2][i] = val++;
        for(int i = x2; i > x1; i--) res[i][y1] = val++;
        circle(x1 + 1, y1 + 1, x2 - 1, y2 - 1, val, res);
    }
}
