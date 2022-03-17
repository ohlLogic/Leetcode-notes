package com.Leetcode;

/**
 * Leetcode129,求根节点到叶节点数字之和
 * DFS
 */
public class LeetcodeDemo129 {
    int res = 0;
    public int sumNumbers(TreeNode root)
    {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int cur)
    {
        if(root == null) return;

        cur += root.val;
        if(root.left == null && root.right == null)
        {
            res += cur;
            return;
        }

        dfs(root.left, cur * 10);
        dfs(root.right, cur * 10);
    }
}
