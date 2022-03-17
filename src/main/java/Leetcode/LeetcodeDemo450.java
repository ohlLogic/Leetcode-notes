package com.Leetcode;

/**
 * Leetcode450,删除二叉树中的节点
 */
public class LeetcodeDemo450 {
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null) return null;
        if(key > root.val) root.right = deleteNode(root.right, key);
        else if(key < root.val) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode node = root.right;
            while(node.left != null) node = node.left;
            node.left = root.left;
            root = root.right;
        }
        return root;
    }
}
