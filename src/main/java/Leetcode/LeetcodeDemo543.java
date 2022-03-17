package com.Leetcode;

/**
 * Leetcode543,二叉树的直径
 * DFS
 */
public class LeetcodeDemo543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root)
    {
        dfs(root);
        return ans;
    }

    //统计二叉树的最大深度
    public int dfs(TreeNode root)
    {
        if(root == null) return 0;

        int leftH = dfs(root.left), rightH = dfs(root.right);
        ans = Math.max(ans, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}
