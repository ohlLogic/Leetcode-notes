package com.Leetcode;

/**
 * Leetcode54,螺旋矩阵
 * 模拟
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo54 {
    public static void main(String[] args) {

    }
    //模拟四个方向
    public static List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;


        boolean[][] visited = new boolean[n][m];
        //模拟四个方向，顺时针
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int dIndex = 0;
        for(int i = 0; i < m * n; i++)
        {
            list.add(matrix[row][col]);
            visited[row][col] = true;
            int nextrow = row + direction[dIndex][0], nextcol = col + direction[dIndex][1];
            //转向
            if(nextrow < 0 || nextrow >= n || nextcol < 0 || nextcol >= m || visited[nextrow][nextcol]) dIndex = (dIndex + 1) % 4;
            row += direction[dIndex][0];
            col += direction[dIndex][1];
        }
        return list;
    }
}
