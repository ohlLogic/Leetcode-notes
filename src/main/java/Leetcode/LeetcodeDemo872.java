package com.Leetcode;

/**
 * Leetcode872,叶子相似的树
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetcodeDemo872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2)
    {
        List<TreeNode> list1 = get(root1);
        List<TreeNode> list2 = get(root2);
        if(list1.size() != list2.size()) return false;
        for(int i = 0; i < list1.size(); i++)
        {
            if(list1.get(i).val != list2.get(i).val) return false;
        }
        return true;
    }

    //层次遍历
    public List<TreeNode> get(TreeNode root)
    {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        deque.addLast(root);
        while(!deque.isEmpty())
        {
            TreeNode node = deque.pollLast();
            if(node.left == null && node.right == null) list.add(node);

            if(node.left != null) deque.addLast(node.left);
            if(node.right != null) deque.addLast(node.right);
        }
        return list;
    }
}
