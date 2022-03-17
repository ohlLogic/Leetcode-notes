package com.Leetcode;

/**
 * Leetcode515, 在每个树中找最大值
 * 层次遍历
 */

import java.util.ArrayList;
import java.util.List;

import static com.Leetcode.LeetcodeDemo102.levelOrder;

public class LeetcodeDemo515 {
    public static void main(String[] args) {

    }

    public static List<Integer> largestValues(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            int max = 0;
            for (Integer integer : list) {
                max = Math.max(max, integer);
            }
            res.add(max);
        }
        return res;
    }
}
