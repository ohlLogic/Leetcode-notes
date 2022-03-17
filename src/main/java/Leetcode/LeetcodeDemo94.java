package com.Leetcode;

/**
 * Leetcode94,二叉树中序遍历
 */

import java.util.*;

public class LeetcodeDemo94 {
    public static void main(String[] args) {

    }

    //递归
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //迭代
    public List<Integer> inorderTraversal1(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> d = new ArrayDeque<>();
        while(root != null || !d.isEmpty())
        {
            //1.不断将左子树压入栈
            while(root != null)
            {
                d.addLast(root);
                root = root.left;
            }

            //2.将最后一个压入栈顶的节点弹出，加入res
            root = d.pollLast();
            res.add(root.val);


            //3.将弹出节点的右节点作为当前节点
            root = root.right;
        }
        return res;
    }

    //Morris
    public List<Integer> inorderTraversal2(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while(cur1 != null)
        {
            cur2 = cur1.left;
            if(cur2 != null)
            {
                while(cur2.right != null && cur2.right != cur1) cur2 = cur2.right;
                if(cur2.right == null)
                {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else cur2.right = null;
            }
            list.add(cur1.val);
            cur1 = cur1.right;
        }
        return list;
    }
}

