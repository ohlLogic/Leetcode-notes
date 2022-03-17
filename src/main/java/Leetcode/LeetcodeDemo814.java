package com.Leetcode;

/**
 * Leetcode814,二叉树剪枝
 */
public class LeetcodeDemo814 {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode root)
    {
        if(root == null) return null;

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if(root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }
}
