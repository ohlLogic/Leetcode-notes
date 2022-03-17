package com.Leetcode;

/**
 * Leetcode112,路径总和
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeDemo112 {
    public static void main(String[] args) {

    }

    //递归
    public static boolean hasPathSum(TreeNode root, int targetSum)
    {
        return dfs(root, targetSum);
    }

    public static boolean dfs(TreeNode root, int targetSum)
    {
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum == root.val;

        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }

    /**
     * 层次遍历，利用两个队列
     * 一个队列用来保存节点，另一个队列用来保存当前节点路径和
     */

    public static boolean hasPathSum1(TreeNode root, int targerSum)
    {
        if(root == null) return false;

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);

        while(!queueNode.isEmpty())
        {
            TreeNode temp = queueNode.poll();
            int val = queueVal.poll();
            if(temp.left == null && temp.right == null)
            {
                if(val == targerSum) return true;
                continue;
            }

            if(temp.left != null)
            {
                queueNode.offer(temp.left);
                queueVal.offer(temp.left.val + val);
            }
            if(temp.right != null)
            {
                queueNode.offer(temp.right);
                queueVal.offer(temp.right.val + val);
            }
        }
        return false;
    }
}
