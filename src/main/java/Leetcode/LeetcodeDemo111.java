package com.Leetcode;

/**
 * Leetcode111,二叉树的最小深度
 * 层次遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeDemo111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root)
    {
        if(root == null) return 0;
        List<List<TreeNode>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<TreeNode> ll = new ArrayList<>();
            int len = queue.size();
            while(len > 0)
            {
                TreeNode temp = queue.poll();
                ll.add(temp);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue .add(temp.right);
                len--;
            }
            list.add(ll);
        }
        int tag = list.size();
        boolean ts = true;
        for (int i = 0; i < list.size() && ts; i++) {
            for (TreeNode tt : list.get(i)) {
                if(tt.left == null && tt.right == null)
                {
                    tag = i + 1;
                    ts = false;
                    break;
                }
            }
        }
        return tag;
    }

}
