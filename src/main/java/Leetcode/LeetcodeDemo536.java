package com.Leetcode;

/**
 * Leetcode563,二叉树的浓度
 */
public class LeetcodeDemo536 {
    int res;
    public int findTilt(TreeNode root)
    {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root)
    {
        if(root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        res += Math.abs(l - r);
        return l + r + root.val;
    }
}
