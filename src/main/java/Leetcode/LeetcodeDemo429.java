package com.Leetcode;

/**
 * Leetcode429,N叉数的层次遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeDemo429 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> leverOrder1(Node root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> ll = new ArrayList<>();
            int len = queue.size();

            while(len > 0)
            {
                Node temp = queue.poll();
                ll.add(temp.val);
                if(!temp.children.isEmpty())
                {
                    for (Node child : temp.children) {
                        queue.add(child);
                    }
                }
                len--;
            }
            res.add(ll);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
