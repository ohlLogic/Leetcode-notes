package com.Leetcode;

/**
 * Leetcode25,K个一组反转链表
 */

public class LeetcodeDemo25 {
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode pre = dummpy;

        while(head != null)
        {
            ListNode tail = pre;
            //查看长度是否大于等于k
            for(int i = 0; i < k; i++)
            {
                tail = tail.next;
                if(tail == null) return dummpy.next;
            }

            //保存下一个段链表
            ListNode nex = tail.next;
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0]; tail = reverse[1];

            //重新连接链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummpy.next;
    }


    public ListNode[] reverseList(ListNode head, ListNode tail)
    {
        ListNode prev = tail.next, p = head;
        while(prev != tail)
        {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
