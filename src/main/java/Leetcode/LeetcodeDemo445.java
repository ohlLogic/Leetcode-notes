package com.Leetcode;

/**
 * Leetcode445,两数相加2
 * 模拟
 */
public class LeetcodeDemo445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode newl1 = reverse(l1), newl2 = reverse(l2);

        //模拟
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while(newl1 != null || newl2 != null || carry != 0)
        {
            int a = newl1 == null ? 0 : newl1.val, b = newl2 == null ? 0 : newl2.val;
            int cur = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            p.next = new ListNode(cur);
            p = p.next;
            if(newl1 != null) newl1 = newl1.next;
            if(newl2 != null) newl2 = newl2.next;
        }
        p.next = null;
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
