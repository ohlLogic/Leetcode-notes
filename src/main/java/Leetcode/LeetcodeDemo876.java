package com.Leetcode;

/**
 * Leetcode876,链表的中间结点
 * 快慢指针
 */
public class LeetcodeDemo876 {
    public ListNode middleNode(ListNode head)
    {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
