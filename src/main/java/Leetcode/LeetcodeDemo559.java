package com.Leetcode;

/**
 * N叉树的最大深度
 * 层次遍历, DFS
 */

import java.util.*;
public class LeetcodeDemo559 {
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
    }
    public int maxDepth(Node root)
    {
        if(root == null) return 0;

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> d =  new ArrayDeque<>();
        d.addLast(root);

        while(!d.isEmpty())
        {
            int len = d.size();
            List<Integer> cur = new ArrayList<>();
            while(len-- > 0)
            {
                Node t = d.pollFirst();
                cur.add(t.val);
                for(int i = 0; i < t.children.size(); i++) d.addLast(t.children.get(i));
            }
            res.add(cur);
        }
        return res.size();
    }

    //DFS
    public int maxDepth1(Node root)
    {
        if(root == null) return 0;

        int ans = 0;
        for(Node node : root.children)
        {
            ans = Math.max(ans, maxDepth1(node));
        }
        return ans + 1;
    }
}
