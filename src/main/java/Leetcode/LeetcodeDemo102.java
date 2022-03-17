package com.Leetcode;

/**
 * Leetcode102,二叉树的层次遍历
 * BFS广度搜索(队列)
 * 1.首先创建一个队列，二叉树的根结点放入队列
 * 2.循环部分：(终止条件为队空)
 *   计算当前队列的size
 *   遍历当前层数(终止条件为size==0)
 *   创建当前层数的list
 *   每次取出队列首结点，将该结点的值放入list
 *   如果该结点的左结点不为空，加入队列;如果该结点的右结点不为空，加入队列
 *   size--
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeDemo102 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        //用队列实现BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            List<Integer> ll = new ArrayList<>();
            int len = queue.size();

            while(len > 0)
            {
                TreeNode temp = queue.poll();
                ll.add(temp.val);
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
                len--;
            }
            list.add(ll);
        }
        return list;
    }
}
