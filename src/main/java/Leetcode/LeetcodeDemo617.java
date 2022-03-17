package com.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode617,合并二叉树
 * DFS,BFS
 */
public class LeetcodeDemo617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2)
    {
        if(root1 == null || root2 == null) return root1 == null ? root2 : root1;

        root1.val += root2.val;
        TreeNode left = dfs(root1.left, root2.left);
        TreeNode right = dfs(root1.right, root2.right);
        root1.left = left;
        root1.right = right;
        return root1;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2)
    {
        if(root1 == null || root2 == null) return root1 == null ? root2 : root1;

        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root1);
        d.addLast(root2);

        while(!d.isEmpty())
        {
            TreeNode r1 = d.remove();
            TreeNode r2 = d.remove();
            r1.val += r2.val;

            if(r1.left != null && r2.left != null)
            {
                d.addLast(r1.left);
                d.addLast(r2.left);
            }
            else if(r1.left == null) r1.left = r2.left;

            if(r1.right != null && r2.right != null)
            {
                d.addLast(r1.right);
                d.addLast(r2.right);
            }
            else if(r1.right == null) r1.right = r2.right;


        }

        return root1;
    }
}
