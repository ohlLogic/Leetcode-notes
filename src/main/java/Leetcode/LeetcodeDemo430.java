package com.Leetcode;

/**
 * Leetcode430,扁平化多级双向链表
 */
public class LeetcodeDemo430 {
    class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int val) {this.val = val;}
}
    //递归
    public Node flatten(Node head)
    {
        Node dummy = new Node(0);
        dummy.next = head;
        while(head != null)
        {
            if(head.child == null) head = head.next;
            else{
                //保存head之后的节点
                Node temp = head.next;

                //递归找到head.child
                Node chead = flatten(head.child);

                //扁平化
                head.next = chead;
                chead.prev = head;
                head.child = null;

                while(head.next != null) head = head.next;
                head.next = temp;
                if(temp != null) temp.prev = head;
                head = temp;
            }
        }
        return dummy.next;
    }

    //递归优化
    Node dfs(Node head)
    {
        Node last = head;
        while(head != null)
        {
            if(head.child == null)
            {
                last = head;
                head = head.next;
            }
            else{
                Node temp = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if(childLast != null) childLast.next = temp;
                if(temp != null) temp.prev = childLast;
                last = head;
                head = childLast;
            }
        }
        return last;
    }

    //迭代
    public Node flatten1(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        for (; head != null; head = head.next) {
            if (head.child != null) {
                Node tmp = head.next;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) last = last.next;
                last.next = tmp;
                if (tmp != null) tmp.prev = last;
            }
        }
        return dummy.next;
    }
}

