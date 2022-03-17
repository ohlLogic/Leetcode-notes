package com.Leetcode;

/**
 * Leetcode700,二叉搜索树的搜索
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeDemo700 {
    public static void main(String[] args) {

    }

    //层次遍历法 + 二叉搜索树
    public static TreeNode searchBST(TreeNode root, int val)
    {
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            if(temp.val == val) return temp;
            else if(temp.val < val && temp.right != null) queue.offer(temp.right);
            else if(temp.val > val && temp.left != null) queue.offer(temp.left);
        }
        return null;
    }

    //递归
    public static TreeNode searchBST1(TreeNode root, int val)
    {
        if(root == null || val == root.val) return root;

        return val < root.val ? searchBST1(root.left, val) : searchBST1(root.right, val);
    }
}
