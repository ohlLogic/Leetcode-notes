package com.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode145,二叉树后序遍历
 */
public class LeetcodeDemo145 {
    public static void main(String[] args) {

    }

    //递归
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> list)
    {
        if(root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    //迭代
    public List<Integer> postorderIraersal1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode peek = st.peek();
            //进入左子树
            if(peek.left != null && peek.left != cur && peek.right != cur) st.push(peek.left);
            //进入右子树
            else if(peek.right != null && peek.right != cur) st.push(peek.right);
            else{
                list.add(st.pop().val);
                cur = peek;
            }
        }
        return list;
    }
}
