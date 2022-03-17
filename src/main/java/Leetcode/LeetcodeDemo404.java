package com.Leetcode;

/**
 * Leetcode404,左叶子之和
 * DFS
 */

public class LeetcodeDemo404 {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root)
    {
       dfs(root);
       return res;
    }

    public void dfs(TreeNode root)
    {
        if(root == null) return;
        dfs(root.left);
        if(root.left != null && root.left.left == null && root.left.right == null) res += root.left.val;
        dfs(root.right);
    }

    //自底向上
    public TreeNode dfs1(TreeNode root)
    {
        if(root == null) return null;

        TreeNode left = dfs1(root.left);
        TreeNode right = dfs1(root.right);
        if(left != null && left.right == null && left.left == null) res += left.val;
        return root;
    }
}
