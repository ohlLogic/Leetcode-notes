package com.Leetcode;

/**
 * Leetcode109,有序链表转换二叉搜索树
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo109 {
    //数组 + 二分dfs
    public TreeNode sortedListToBST(ListNode head)
    {
        List<Integer> list = new ArrayList<>();
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return dfs(res, 0, res.length - 1);
    }

    public TreeNode dfs(int[] res, int l, int r)
    {
        if(l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(res[mid]);
        root.left = dfs(res, l, mid - 1);
        root.right = dfs(res, mid + 1, r);
        return root;
    }

    //分治法
    public TreeNode sortedListToBST1(ListNode head)
    {
        //左闭右开原则
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right)
    {
        if(left == right) return null;
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    //快慢指针，当快指针移动到末尾，此时慢指针就是中位数节点
    public ListNode getMid(ListNode left, ListNode right)
    {
        ListNode fast = left, slow = left;
        while(fast != right && fast.next != right)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //
}
