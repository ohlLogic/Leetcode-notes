package com.Leetcode;

/**
 * Leetcode885，螺旋矩阵3
 * 模拟
 */
public class LeetcodeDemo885 {
    public static void main(String[] args) {
        int[][] res = spiralMatrixIII(5, 6, 1, 4);
        for (int[] re : res) {
            for (int i : re) {
                System.out.println(i);
            }
        }
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart)
    {
        int[][] res = new int[rows * cols][2];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 1, dIndex = 0, x = rStart, y = cStart;
        int left = cStart - 1, right = cStart + 1, up = rStart - 1, down = rStart + 1;
        while(i <= rows * cols)
        {
            //判断x,y是否在矩阵中
            if(x >= 0 && x < rows && y >= 0 && y < cols)
            {
                res[i - 1][0] = x;
                res[i - 1][1] = y;
                i++;
            }
            //向右到达右边界
            if(dIndex == 0 && y == right)
            {
                //转向
                dIndex++;
                //由边界扩大1
                right++;
            }
            else if(dIndex == 1 && x == down)
            {
                dIndex++;
                down++;
            }
            else if(dIndex == 2 && y == left)
            {
                dIndex++;
                left--;
            }
            else if(dIndex == 3 && x == up)
            {
                dIndex = 0;
                up--;
            }
            x += direction[dIndex][0];
            y += direction[dIndex][1];

        }

        return res;
    }
}
