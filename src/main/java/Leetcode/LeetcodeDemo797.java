package com.Leetcode;

/**
 * Leetcode797，所有可能的路径
 * DFS
 */

import java.util.*;

public class LeetcodeDemo797 {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    int[][] graph;
    //DFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        n = graph.length;
        this.graph = graph;
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(0, cur);
        return res;
    }

    public void dfs(int idx, List<Integer> cur)
    {
        if(idx == n - 1)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int next : graph[idx])
        {
            cur.add(next);
            dfs(next, cur);
            cur.remove(cur.size() - 1);
        }
    }

    //BFS

    class Node{
        int index;
        List<Integer> path;

        Node(int index)
        {
            this.index = index;
            this.path = new ArrayList<>();
            this.path.add(index);
        }

        Node(int index, List<Integer> path)
        {
            this.index = index;
            //复制一个新的list
            this.path = new ArrayList<>(path);
            this.path.add(index);
        }
    }
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph)
    {
        n = graph.length;
        Deque<Node> d = new ArrayDeque<>();
        d.addLast(new Node(0));

        while(!d.isEmpty())
        {
            Node node = d.pollFirst();
            if(node.index == n - 1)
            {
                res.add(node.path);
                continue;
            }
            for(int next : graph[node.index]) d.addLast(new Node(next, node.path));
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {}, {4}, {}};
        LeetcodeDemo797 tt = new LeetcodeDemo797();
        System.out.println(tt.allPathsSourceTarget(graph));
    }
}
