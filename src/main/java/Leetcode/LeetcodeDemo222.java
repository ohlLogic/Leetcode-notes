package com.Leetcode;

/**
 * Leetcode,完全二叉树的节点个数
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo222 {
    //层序遍历
    public int countNodes(TreeNode root)
    {
        if(root == null) return 0;
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);

        int cnt = 0;
        while(!d.isEmpty())
        {
            int len = d.size();
            cnt += len;
            while(len-- > 0)
            {
                TreeNode cur = d.pollFirst();
                if(cur.left != null) d.addLast(cur.left);
                if(cur.right != null) d.addLast(cur.right);
            }
        }
        return cnt;
    }

    //DFS
    public int countNodes1(TreeNode root)
    {
        return dfs(root);
    }

    public int dfs(TreeNode root)
    {
        if(root == null) return 0;

        return dfs(root.left) + dfs(root.right) + 1;
    }

}
