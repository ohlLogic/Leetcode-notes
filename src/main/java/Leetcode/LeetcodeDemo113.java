package com.Leetcode;

/**
 * Leetcode113,路径总和2
 * dfs
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        dfs(root, targetSum);
        return res;
    }

    void dfs(TreeNode root, int targetSum)
    {
        if(root == null) return;

        //进入下一层之前减去父节点的值
        list.add(root.val);
        targetSum -= root.val;
        //判断是否到达叶节点
        if(root.left == null && root.right == null && targetSum == 0) res.add(new ArrayList<>(list));

        //dfs
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        //回溯
        list.remove(list.size() - 1);
    }
}
