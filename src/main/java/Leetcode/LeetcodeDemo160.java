package com.Leetcode;

/**
 * Leetcode160,相交链表
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LeetcodeDemo160 {
    //栈
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        Deque<ListNode> d1 = new ArrayDeque<>();
        Deque<ListNode> d2 = new ArrayDeque<>();

        //压栈
        while(headA != null)
        {
            d1.addLast(headA);
            headA = headA.next;
        }

        while(headB != null)
        {
            d2.addLast(headB);
            headB = headB.next;
        }

        //出栈

        ListNode pre = null;
        while(!d1.isEmpty() && !d2.isEmpty())
        {
            if(d1.peekLast() != d2.peekLast()) break;
            else
            {
                pre = d1.pollLast();
                d2.pollLast();
            }

        }
        return pre;
    }

    //哈希集合
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB)
    {
        Set<ListNode> vis = new HashSet<>();
        while(headA != null)
        {
            vis.add(headA);
            headA = headA.next;
        }

        while(headB != null)
        {
            if(vis.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB)
    {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while(pA != pB)
        {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
