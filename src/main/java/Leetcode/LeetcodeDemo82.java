package com.Leetcode;

/**
 * Leetcode82,删除排序链表中的重复元素2
 *
 */
public class LeetcodeDemo82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode res = new ListNode(0, head);
        ListNode cur = res;
        while(cur.next != null && cur.next.next != null)
        {
            if(cur.next.val == cur.next.next.val)
            {
                int x = cur.next.val;
                while(cur.next != null && cur.next.val == x) cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}