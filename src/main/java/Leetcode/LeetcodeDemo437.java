package com.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode437,路径总和3
 * dfs
 */


public class LeetcodeDemo437 {
    int res, t;
    Map<Integer, Integer> map = new HashMap<>();
    //双dfs
    public int pathSum(TreeNode root, int target)
    {
        t = target;
        dfs1(root);
        return res;
    }

    void dfs1(TreeNode root)
    {
        if(root == null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    void dfs2(TreeNode root, int val)
    {
        if(val == t) res++;
        if(root.left != null) dfs2(root.left, val + root.left.val);
        if(root.right != null) dfs2(root.right, val + root.right.val);
    }


    //树的遍历+前缀和
    public int pathSum1(TreeNode root, int target)
    {
        if(root == null) return 0;
        t = target;
        map.put(0, 1);
        dfs(root, root.val);
        return res;
    }

    void dfs(TreeNode root, int val)
    {
        if(map.containsKey(val - t)) res += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if(root.left != null) dfs(root.left, val + root.left.val);
        if(root.right != null) dfs(root.right, val + root.right.val);
        //回溯
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}
