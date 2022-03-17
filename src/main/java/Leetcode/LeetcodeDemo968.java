package com.Leetcode;

/**
 * Leetcode968,监控二叉树
 * 树形DP
 */

public class LeetcodeDemo968 {
    int res;
    public int minCameraCover(TreeNode root)
    {
        res = 0;
        //如果根节点没有覆盖
        if(dfs(root) == 0) res++;
        return res;
    }

    public int dfs(TreeNode root)
    {
        //空节点被覆盖
        if(root == null) return 2;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == 2 && right == 2) return 0;
        if(left == 0 || right == 0) {
            res++;
            return 1;
        }
        if(left == 1 || right == 1) return 2;

        return -1;
    }
}
