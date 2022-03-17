package com.Leetcode;

/**
 * Leetcode240,搜索二维矩阵2
 * 抽象BST，二分
 */
public class LeetcodeDemo240 {
    public static void main(String[] args) {
        LeetcodeDemo240 tt = new LeetcodeDemo240();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(tt.searchMatrix(matrix, 5));
    }

    //二分
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int n = matrix.length, m = matrix[0].length;

        for(int i = 0; i < n; i++)
        {
            int l = 0, r = m - 1;
            while(l < r)
            {
                int mid = l + r >> 1;
                if(matrix[i][mid] >= target) r = mid;
                else l = mid + 1;
            }
            if(matrix[i][r] == target) return true;
        }
        return false;
    }

    //抽象BST
    public boolean searchMatirx1(int[][] matrix, int target)
    {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while(r < m && c >= 0)
        {
            if(matrix[r][c] < target) r++;
            else if(matrix[r][c]  > target) c--;
            else return true;
        }
        return false;
    }

}
