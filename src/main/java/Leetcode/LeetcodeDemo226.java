package com.Leetcode;

/**
 * Leetcode226,翻转二叉树
 * 递归三步骤：
 * 1.递归函数的参数和返回值
 * 2.终止条件
 * 3.单层递归的逻辑
 */
public class LeetcodeDemo226 {
    public static void main(String[] args) {

    }

    //自底向上
    public static TreeNode invertTree(TreeNode root)
    {
        if(root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    //自顶向下
    public static TreeNode invertTree1(TreeNode root)
    {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

}
