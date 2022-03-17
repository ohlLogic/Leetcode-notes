package com.Leetcode;

/**
 * Leetcode938,二叉搜索树的范围和
 * dfs
 */

public class LeetcodeDemo938 {
    int sum = 0;
    int low, high;
    public int rangeSumBSt(TreeNode root, int _low, int _high)
    {
        low = _low; high = _high;
        dfs(root);
        return sum;
    }
    void dfs(TreeNode root)
    {
        if(root == null) return;
        if(root.val >= low && root.val <= high) sum += root.val;
        dfs(root.left);
        dfs(root.right);
    }
}
