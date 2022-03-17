package com.Leetcode;

/**
 * Leetcode783,二叉搜索树节点最小距离
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo783 {
    public int minDiffInBST(TreeNode root)
    {
        Deque<TreeNode> d = new ArrayDeque<>();
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;
        while(root != null || !d.isEmpty())
        {
            while(root != null)
            {
                d.addLast(root);
                root = root.left;
            }

            root = d.pollLast();
            if(pre != null) min = Math.min(min, Math.abs(pre.val - root.val));
            pre = root;

            root = root.right;
        }
        return min;
    }
}
