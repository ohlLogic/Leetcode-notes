package com.Leetcode;

/**
 * Leetcode105,前序，中序构造二叉树
 */
public class LeetcodeDemo105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode traversal(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright)
    {
        //没有元素
        if(inright - inleft < 1) return null;

        //只有叶结点
        if(inright - inleft == 1) return new TreeNode(inorder[inleft]);

        //前序遍历第一个元素作为当前结点
        int val = preorder[preleft];
        TreeNode root = new TreeNode(val);

        //找到中序数组的分割点
        int rootIndex = 0;
        for(int i = inleft; i < inright; i++)
        {
            if(inorder[i] == val)
            {
                rootIndex = i;
                break;
            }
        }

        root.left = traversal(preorder, preleft + 1, preleft + 1 + (rootIndex - inleft), inorder, inleft, rootIndex);
        root.right = traversal(preorder, preleft + 1 + (rootIndex - inleft), preright, inorder, rootIndex + 1, inright);
        return root;
    }
}
