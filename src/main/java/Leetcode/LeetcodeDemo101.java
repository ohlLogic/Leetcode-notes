package com.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeDemo101 {
    public static void main(String[] args) {

    }

    //递归
    public static boolean isSymmetric(TreeNode root)
    {
        if(root == null) return true;
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    //迭代，采用队列
    public static boolean isSymmetric1(TreeNode root)
    {
        if(root == null) return true;
        return check1(root, root);
    }

    public static boolean check1(TreeNode p, TreeNode q)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty())
        {
            p = queue.poll();
            q = queue.poll();
            if(p == null && q == null) continue;

            if((p == null || q == null) || p.val != q.val) return false;

            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
