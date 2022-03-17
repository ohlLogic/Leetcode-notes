package com.Leetcode;

/**
 * LeetcodeDemo99，恢复二叉搜索树
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetcodeDemo99 {
    public static void main(String[] args) {
        LeetcodeDemo99 tt = new LeetcodeDemo99();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        tt.recoverTree(root);
    }
    public void recoverTree(TreeNode root)
    {
        Deque<TreeNode> d = new ArrayDeque<>();
        List<TreeNode> res = new ArrayList<>();
        while(root != null || !d.isEmpty())
        {
            while(root != null)
            {
                d.addLast(root);
                root = root.left;
            }

            root = d.pollLast();
            res.add(root);

            root = root.right;
        }

        int tag1 = -1, tag2 = -1;
        for(int i = 0; i < res.size() - 1; i++)
        {
            if(res.get(i).val > res.get(i + 1).val)
            {
                if(tag1 != -1)
                {
                    tag2 = i + 1;
                    break;
                }
                tag1 = i;
            }
        }
        if(tag2 == -1) swap(res.get(tag1), res.get(tag1 + 1));
        else swap(res.get(tag1), res.get(tag2));
    }

    public void swap(TreeNode p, TreeNode q)
    {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}
