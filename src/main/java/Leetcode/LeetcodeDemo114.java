package com.Leetcode;

/**
 * Leetcode114,二叉树展开为链表
 */

import java.util.*;

public class LeetcodeDemo114 {
    public void flatten(TreeNode root)
    {
        if(root == null) return;
        Deque<TreeNode> d = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        d.addLast(root);
        while(!d.isEmpty())
        {
            TreeNode node = d.pollLast();
            list.add(node);
            if(node.right != null) d.addLast(node.right);
            if(node.left != null) d.addLast(node.left);
        }

        for(int i = 0; i < list.size() - 1; i++)
        {
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
    }
}
