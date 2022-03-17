package com.Leetcode;

/**
 * Leetcode230,二叉搜索树中第k小的元素
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class LeetcodeDemo230 {
    public static void main(String[] args) {

    }


    //大顶堆+层次遍历
    public int kthSmallest(TreeNode root, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        Deque<TreeNode> d = new ArrayDeque<>();

        d.addLast(root);

        while(!d.isEmpty())
        {
            TreeNode node = d.pollFirst();
            if(q.size() < k) q.add(node.val);
            else if(q.peek() > node.val)
            {
                q.poll();
                q.add(node.val);
            }

            if(node.left != null) d.addLast(node.left);
            if(node.right != null) d.addLast(node.right);
        }
        return q.peek();
    }

    //中序遍历
    public int kthSmallest1(TreeNode root, int k)
    {
        Deque<TreeNode> d = new ArrayDeque<>();
        while(root != null || !d.isEmpty())
        {
            while(root != null)
            {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
