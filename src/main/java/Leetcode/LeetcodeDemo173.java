package com.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode173,二叉搜索树迭代器
 * 设计类题目
 */
public class LeetcodeDemo173 {
    Deque<TreeNode> d = new ArrayDeque<>();
    public static void main(String[] args) {

    }
    public LeetcodeDemo173(TreeNode root)
    {
        dfsLeft(root);
    }

    public int next()
    {
        TreeNode root = d.pollLast();
        int res = root.val;

        root = root.right;

        dfsLeft(root);
        return res;
    }

    public boolean hasNext()
    {
        return !d.isEmpty();
    }

    void dfsLeft(TreeNode root)
    {
        while(root != null)
        {
            d.addLast(root);
            root = root.left;
        }
    }
}
