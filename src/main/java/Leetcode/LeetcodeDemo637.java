package com.Leetcode;

/**
 * Leetcode637,二叉树的层平均值
 * 层次遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeDemo637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }
    public static List<Double> averageOfLevels(TreeNode root)
    {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        List<List<Double>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Double> ll = new ArrayList<>();
            int len = queue.size();
            double sum = 0;
            while(len > 0)
            {
                TreeNode temp = queue.poll();
                ll.add((double)temp.val);
                sum += temp.val;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                len--;
                if(len == 0) ll.add(sum);
            }
            list.add(ll);
        }
        for (List<Double> doubles : list) {
            res.add(doubles.get(doubles.size() - 1) / (doubles.size() - 1));
        }
        return res;
    }
}
