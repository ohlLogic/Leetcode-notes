package com.Leetcode;

/**
 * Leetcode199,二叉树的右视图
 * 层次遍历
 */

import java.util.ArrayList;
import java.util.List;

import static com.Leetcode.LeetcodeDemo102.levelOrder;

public class LeetcodeDemo199 {
    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            res.add(list.get(list.size() - 1));
        }
        return res;
    }
}
