package com.Leetcode;

/**
 * Leetcode110，平衡二叉树
 */
public class LeetcodeDemo110 {
    //自顶向下
    public boolean isBalanced(TreeNode root)
    {
        if(root == null) return true;
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     *
     * @param root 根节点
     * @return 树的高度
     */
    public int dfs(TreeNode root)
    {
        if(root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }


    //自底向上
    public boolean isBalanced1(TreeNode root)
    {
        return height(root) >= 0;
    }

    public int height(TreeNode root)
    {
        if(root == null) return 0;
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        if(leftheight == -1 || rightheight == -1 || Math.abs(leftheight - rightheight) > 1) return -1;
        else return Math.max(leftheight, rightheight) + 1;
    }
}
