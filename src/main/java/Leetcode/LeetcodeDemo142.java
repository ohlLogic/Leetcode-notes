package com.Leetcode;

/**
 * Leetcode142,环形链表2
 * 快慢指针
 */
public class LeetcodeDemo142 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;
        LeetcodeDemo142 tt = new LeetcodeDemo142();
        System.out.println(tt.detectCycle(node));
    }
    public ListNode detectCycle(ListNode head)
    {
        //1.判断链表是否有环
        if(head == null) return head;

        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        //无环
        if(fast == null || fast.next == null) return null;

        ListNode temp = fast;
        int len = 0;
        while(fast.next != temp)
        {
            fast = fast.next;
            len++;
        }
        //倒数len个节点
        fast = head; slow = head;
        while(len-- > 0) fast = fast.next;

        while(slow != fast.next)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
