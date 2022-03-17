package com.Leetcode;

/**
 * Leetcode98,验证二叉搜索树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeDemo98 {
    public static void main(String[] args) {

    }

    //代码有误，不能保存右子树所有节点大于根节点
    public static boolean isValidBST(TreeNode root)
    {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            if(temp.left != null) {
                if(temp.left.val >= temp.val) return false;
                else queue.offer(temp.left);
            }
            if(temp.right != null) {
                if(temp.right.val <= temp.val) return false;
                else queue.offer(temp.right);
            }

        }
        return true;
    }

    //中序遍历，将树节点放在数组中，判断数组是否为递增即可
    public static boolean inValidBST1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        MidOrder(root, list);
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }
    public static void MidOrder(TreeNode root, List<Integer> list)
    {
        if(root == null) return;

        MidOrder(root.left, list);
        list.add(root.val);
        MidOrder(root.right, list);
    }

    //递归,根绝二叉搜索树的性质定义上下界搜索
    public static boolean inVaildBST2(TreeNode root)
    {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isBST(TreeNode root, long lower, long higher)
    {
        if(root == null) return true;
        if(root.val >= higher || root.val <= lower) return false;
        return isBST(root.left, lower, root.val) && isBST(root.right, root.val, higher);
    }
}
