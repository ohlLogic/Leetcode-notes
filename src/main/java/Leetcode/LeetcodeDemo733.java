package com.Leetcode;

/**
 * Leetcode733,图像渲染
 * dfs
 */
public class LeetcodeDemo733 {
    int[][] image;
    int m, n;
    int newColor, oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        m = image.length; n = image[0].length;
        this.image = image; this.newColor = newColor;

        oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        dfs(sr, sc);
        return image;
    }

    public void dfs(int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor) return;

        //染色
        image[x][y] = newColor;

        //模拟四个方向
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
