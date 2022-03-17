package com.Leetcode;

/**
 * Leetcode513,找树左下角的值
 * 层次遍历
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int res = root.val;
        boolean flag = false;
        while (!d.isEmpty()) {
            //记录同层结点的个数
            int len = d.size();
            flag = true;
            while (len-- > 0) {
                TreeNode node = d.pollFirst();
                if (flag) {
                    res = node.val;
                    flag = false;
                }
                if (node.left != null) {
                    d.addLast(node.left);
                }
                if (node.right != null) {
                    d.addLast(node.right);
                }
            }
        }
        return res;
    }
}
