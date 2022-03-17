package com.Leetcode;

/**
 * Leetcode897,递增顺序搜索树
 * 中序遍历
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetcodeDemo897 {
    public TreeNode increasingBST(TreeNode root)
    {
        Deque<TreeNode> d = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        d.addLast(root);
        while(root != null || !d.isEmpty())
        {
            while(root != null)
            {
                d.addLast(root);
                root = root.left;
            }

            root = d.pollLast();
            list.add(root);

            root = root.right;
        }

        for(int i = 0; i < list.size() - 1; i++)
        {
            TreeNode cur = list.get(i);
            cur.left = null;
            cur.right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }
}
