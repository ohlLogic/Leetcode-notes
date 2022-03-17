package com.Leetcode;

/**
 * Leetcode106,从后序和中序遍历序列构造二叉树
 */
public class LeetcodeDemo106 {
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if(inorder.length == 0 || postorder.length == 0) return null;
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode traversal(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright) {
        //没有元素
        if(inright - inleft < 1) return null;

        //如果只有一个元素
        if(inright - inleft == 1) return new TreeNode(inorder[inleft]);

        int val = postorder[postright - 1];
        TreeNode root = new TreeNode(val);

        //找到中序数组中的位置
        int rootIndex = 0;
        for(int i = inleft; i < inright; i++)
        {
            if(inorder[i] == val) {
                rootIndex = i;
                break;
            }
        }

        //根据rootIndex分割左右子树
        root.left = traversal(inorder, inleft, rootIndex, postorder, postleft, postleft + (rootIndex - inleft));
        root.right = traversal(inorder, rootIndex + 1, inright, postorder, postleft + (rootIndex - inleft), postright - 1);
        return root;
    }


}
