package com.Leetcode;

/**
 * Leetcode662,二叉树最大宽度
 * BFS
 */

import java.util.*;
public class LeetcodeDemo662 {
    class PosTreeNode{
        TreeNode node;
        int depth, pos;
        PosTreeNode(TreeNode node, int d, int p)
        {
            this.node = node;
            depth = d;
            pos = p;
        }
    }
    public int widthOfBinaryTree(TreeNode root)
    {
        Deque<PosTreeNode> d = new ArrayDeque<>();
        d.addLast(new PosTreeNode(root, 0, 0));

        int preDepth = 0, left = 0, ans = 0;
        while(!d.isEmpty())
        {
            PosTreeNode cur = d.pollFirst();
            if(cur.node != null)
            {
                d.addLast(new PosTreeNode(cur.node.left, cur.depth + 1, cur.pos * 2));
                d.addLast(new PosTreeNode(cur.node.right, cur.depth + 1, cur.pos * 2 + 1));
                //新的一层，第一次更新
                if(preDepth != cur.depth)
                {
                    preDepth = cur.depth;
                    left = cur.pos;
                }
                ans = Math.max(ans, cur.pos - left + 1);
            }
        }
        return ans;
    }
}
