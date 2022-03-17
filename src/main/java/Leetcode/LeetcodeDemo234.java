package com.Leetcode;

/**
 * Leetcode234,回文链表
 *
 */
public class LeetcodeDemo234 {
    public static void main(String[] args) {
        LeetcodeDemo234 tt = new LeetcodeDemo234();
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        root.next.next.next.next = null;
        System.out.println(tt.isPalindrome(root));
    }
    public boolean isPalindrome(ListNode head)
    {
        if(head == null) return true;

        //1.快慢指针找到head的中间节点
        ListNode mid = find(head);

        //2.对中间节点之后的链表进行反转
        ListNode next = reverse(mid.next);

        //3.判断
        while(next != null)
        {
            if(head.val != next.val) return false;
            head = head.next;
            next = next.next;
        }
        return true;
    }

    public ListNode reverse(ListNode root)
    {
        if(root == null || root.next == null) return root;

        ListNode newHead = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }

    public ListNode find(ListNode root)
    {
        ListNode fast = root, slow = root;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
