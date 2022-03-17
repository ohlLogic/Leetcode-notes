package com.Leetcode;

/**
 * Leetcode138,复制带随机指针的链表
 */


public class LeetcodeDemo138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head)
    {
        if(head == null) return null;

        Node cur = head;
        //在原链表每个结点之后复制当前节点
        while(cur != null)
        {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        //为当前链表每个新节点的random属性赋值
        cur = head;
        while(cur != null)
        {
            if(cur.random != null)
            {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head.next;
        Node res = head.next;
        Node pre = head;
        while(cur.next != null)
        {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
