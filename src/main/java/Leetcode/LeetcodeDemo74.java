package com.Leetcode;

/**
 * Leetcode74,搜索二维矩阵
 * 二分
 */
public class LeetcodeDemo74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 4));

    }

    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix.length, n = matrix[0].length;
        int index = 0;
        boolean tag = true;
        for(int i = 0; i < m; i++)
        {
            if(matrix[i][0] <= target && matrix[i][n - 1] >= target)
            {
                index = i;
                tag = !tag;
                break;
            }
        }
        if(tag) return false;

        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(matrix[index][mid] <= target) l = mid;
            else r = mid - 1;
        }
        return matrix[index][l] == target;
    }
}
