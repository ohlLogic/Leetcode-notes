package com.Leetcode;

/**
 * Leetcode701,二叉搜索树的插入操作
 */

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeDemo701 {
    public static void main(String[] args) {

    }

    //层次遍历
    public static TreeNode insertIntoBST(TreeNode root, int val)
    {
        if(root == null) return new TreeNode(val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            if(temp.val < val)
            {
                if(temp.right != null) queue.offer(temp.right);
                else temp.right = new TreeNode(val);
            }
            else
            {
                if(temp.left != null) queue.offer(temp.left);
                else temp.left = new TreeNode(val);
            }
        }
        return root;
    }

    //递归
    public static TreeNode insertIntoBST1(TreeNode root, int val)
    {
        if(root == null) return new TreeNode(val);

        if(root.val > val) root.left = insertIntoBST1(root.left, val);
        if(root.val < val) root.right = insertIntoBST1(root.right, val);
        return root;
    }
}
