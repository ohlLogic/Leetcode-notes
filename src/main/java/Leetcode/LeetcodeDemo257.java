package com.Leetcode;

/**
 * Leetcode257,二叉树的所有路径
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root)
    {
        dfs(root, "");
        return res;
    }


    public void dfs(TreeNode root, String path)
    {
        if(root == null) return;

        path += root.val;

        if(root.left == null && root.right == null) res.add(path);
        else{
            path += "->";
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }
}
