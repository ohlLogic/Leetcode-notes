package com.Leetcode;

/**
 * Leetcode236,二叉树的最近公共祖先节点
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetcodeDemo236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        List<TreeNode> list = new ArrayList<>();
        while (!d.isEmpty()) {
            TreeNode node = d.pollFirst();
            list.add(node);
            if (node.left != null) d.addLast(node.left);
            if (node.right != null) d.addLast(node.right);
        }

        TreeNode x = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            x = list.get(i);
            if (dfs(x, p) && dfs(x, q)) return x;
        }
        return x;
    }

    public boolean dfs(TreeNode root, TreeNode p) {
        if (root == null) return false;

        if (root.val == p.val) return true;

        return dfs(root.left, p) || dfs(root.right, p);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
