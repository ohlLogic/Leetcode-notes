package com.Leetcode;

/**
 * Leetcode144,二叉树前序遍历
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetcodeDemo144 {
    public static void main(String[] args) {
        TreeNode tt = new TreeNode(1);
    }

    //递归
    public  List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    //迭代
    public List<Integer> preorderTraversal1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        //将头结点放入stack
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }

        return list;
    }

    //Morris法
    public List<Integer> preorderTraversal2(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        TreeNode cur1 = root; //当前遍历结点
        TreeNode cur2 = null; //记录当前结点的左子树
        while(cur1 != null)
        {
            cur2 = cur1.left;
            if(cur2 != null)
            {
                //找到当前左子树的最右侧结点(在这个结点指向根结点之前)
                while(cur2.right != null && cur2.right != cur1) cur2 = cur2.right;

                //如果最右侧这个节点的右指针没有指向根结点，创建连接然后往下一个左子树的根结点进行连接操作
                if(cur2.right == null)
                {
                    cur2.right = cur1;
                    list.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                }else
                {
                    //当左子树的最右侧节点有指向根结点，此时说明我们已经回到了根结点并重复了之前的操作，同时在回到根结点的时候我们应该已经处理完左子树的最右侧节点，把路断开
                    cur2.right = null;
                }
            }else list.add(cur1.val);
            cur1 = cur1.right; //往右走
        }
        return list;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}