package com.Leetcode;

/**
 * Leetcode107,二叉树的层次遍历2
 */

import java.util.ArrayList;
import java.util.List;

import static com.Leetcode.LeetcodeDemo102.levelOrder;

public class LeetcodeDemo107 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> lists = levelOrder(root);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = lists.size() - 1; i >= 0; i--) res.add(lists.get(i));
        return res;
    }
}
