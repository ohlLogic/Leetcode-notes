package com.Leetcode;

/**
 * Leetcode993,二叉树的堂兄弟节点
 * bfs，dfs
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo993 {
    public boolean isCousins(TreeNode root, int x, int y)
    {
        int[] xi = dfs(root, null, 0, x);
        int[] yi = dfs(root, null, 0, y);
        return xi[1] == yi[1] && xi[0] != yi[0];
    }

    //dfs
    public int[] dfs(TreeNode root, TreeNode fa, int depth, int target)
    {
        if(root == null) return new int[]{-1, -1}; //使用-1代表搜索不到target
        if(root.val == target) return new int[]{fa != null ? fa.val : 1, depth}; //使用1代表target为root

        int[] l = dfs(root.left, root, depth + 1, target);
        if(l[0] != -1) return l;
        return dfs(root.right, root, depth + 1, target);
    }

    //bfs
    public int[] bfs(TreeNode root, int target)
    {
        Deque<Object[]> d = new ArrayDeque<>(); //存储[cur, fa, depth]
        d.addLast(new Object[]{root, null, 0});
        while(!d.isEmpty())
        {
            int size = d.size();
            while(size-- > 0)
            {
                Object[] poll = d.pollFirst();
                TreeNode cur = (TreeNode)poll[0], fa = (TreeNode) poll[1];
                int depth = (Integer) poll[2];
                if(cur.val == target) return new int[]{fa != null ? fa.val : 0, depth};
                if(cur.left != null) d.addLast(new Object[]{cur.left, cur, depth + 1});
                if(cur.right != null) d.addLast(new Object[]{cur.right, cur, depth + 1});
            }
        }
        return new int[]{-1, -1};
    }
}
