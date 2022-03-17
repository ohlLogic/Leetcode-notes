package com.Leetcode;

/**
 * Leetcode143,重排链表
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo143 {
    public void reorderList(ListNode head)
    {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while(p != null)
        {
            list.add(p);
            p = p.next;
        }
        int n = list.size() - 1;
        ListNode cur = head;
        int l = 1, r = n;
        while(l < r)
        {
            cur.next = list.get(r--);
            cur = cur.next;
            if(l == r) break;
            cur.next = list.get(l++);
            cur = cur.next;
        }
        cur.next = list.get(l);
        cur.next.next = null;
    }


    /**
     * 1.寻找链表的中点（快慢指针）
     * 2.将原链表的右半段反转（反转链表）
     * 3.将原链表合并
     */

    public void reorderList1(ListNode head)
    {
        if(head == null) return;

        //1.找到链表中点
        ListNode mid = getmid(head);


        //2.反转右端链表
        ListNode next = reverseList(mid.next);
        mid.next = null;
        //3.合并链表
        mergeList(head, next);
    }

    public ListNode getmid(ListNode head)
    {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void mergeList(ListNode l1, ListNode l2)
    {
        ListNode tmp1, tmp2;
        while(l1 != null && l2 != null)
        {
            tmp1 = l1.next;
            tmp2 = l2.next;

            l1.next = l2;
            l1 = tmp1;

            l2.next = l1;
            l2 = tmp2;
        }
    }
}
