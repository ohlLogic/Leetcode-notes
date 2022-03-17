package com.Leetcode;

/**
 * Leetcode104,二叉树的最大深度
 * 层次遍历
 */

import java.util.List;

import static com.Leetcode.LeetcodeDemo102.levelOrder;

public class LeetcodeDemo104 {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root)
    {
        if(root == null) return 0;
        List<List<Integer>> lists = levelOrder(root);
        return lists.size();
    }
}
