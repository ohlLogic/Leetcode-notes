package com.Leetcode;

/**
 * Leetcode24，两两交换链表中的节点
 */
public class LeetcodeDemo24 {
    //直接扫描一遍，交换两个节点的值
    public ListNode swapPairs(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode p = head, q = head.next;

        while(p != null && q != null)
        {
            swap(p, q);
            if(q.next == null) break;
            p = q.next;
            if(p.next == null) break;
            q = p.next;
        }
        return head;
    }

    public void swap(ListNode p, ListNode q)
    {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    //递归，实际交换节点
    public ListNode swapPairs1(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //迭代，实际交换节点
    public ListNode swapPairs2(ListNode head)
    {
        ListNode res = new ListNode(0, head);
        ListNode p = res;
        while(p.next != null && p.next.next != null)
        {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;

            //交换
            p.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            p = node1;
        }

        return res.next;
    }
}
