package com.Leetcode;

/**
 * Leetcode100,相同的树
 * 递归
 */
public class LeetcodeDemo100 {
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        return dfs(p, q);
    }

    public boolean dfs(TreeNode p, TreeNode q)
    {
        //终止条件，如果都为null
        if(p == null && q == null) return true;
        //如果只有一个节点为空
        if(p == null || q == null) return false;

        if(p.val == q.val) return dfs(p.left, q.left) && dfs(p.right, q.right);
        else return false;
    }
}
