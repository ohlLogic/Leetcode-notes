package com.Leetcode;

/**
 * Leetcode141,环形链表
 * 快慢指针
 */
public class LeetcodeDemo141 {
    public boolean hasCycle(ListNode head)
    {
        if(head == null || head.next == null) return false;

        ListNode fast = head.next, slow = head;
        while(slow != fast)
        {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle1(ListNode head)
    {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
