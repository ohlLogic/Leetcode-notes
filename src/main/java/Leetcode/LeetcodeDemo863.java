package com.Leetcode;

/**
 * Leetcode863,二叉树中所有距离为k的结点
 * dfs, 建图bfs
 *
 */

import java.util.*;

public class LeetcodeDemo863 {
    List<Integer> res = new ArrayList<>();
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //从root节点出发，记录每个节点的父节点
        dfsParents(root);

        //从target出发dfs，寻找所有深度为k的节点
        dfs(target, null, 0, k);
        return res;
    }

    void dfsParents(TreeNode root)
    {
        if(root.left != null)
        {
            parents.put(root.left, root);
            dfsParents(root.left);
        }
        if(root.right != null)
        {
            parents.put(root.right, root);
            dfsParents(root.right);
        }
    }

    /**
     *
     * @param node 当前节点
     * @param from 当前节点的前一个节点
     * @param depth 遍历深度
     * @param k 目标
     */
    void dfs(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) return;

        if (depth == k)
        {
            res.add(node.val);
            return;
        }

        //左右子树
        if(node.left != from) dfs(node.left, node, depth + 1, k);
        if(node.right != from) dfs(node.right, node, depth + 1, k);

        //父节点
        if(parents.get(node) != from) dfs(parents.get(node), node, depth + 1, k);

    }

    //建图+bfs
    /**
     * he数组：存储是某个节点所对应的边的集合（链表）的头结点
     * e数组：由于访问某一条边指向的节点
     * ne数组：由于是以链表的形式存边，该数组就是用于找到下一条边
     */
    int N = 510, M = N * 4;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    void add(int a, int b)
    {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    boolean[] vis = new boolean[N];
    public List<Integer> distanceK1(TreeNode root, TreeNode t, int k)
    {
        List<Integer> res = new ArrayList<>();
        //初始化head数组
        Arrays.fill(he, -1);
        dfs1(root);

        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(t.val);
        vis[t.val] = true;
        while(!d.isEmpty() && k >= 0)
        {
            int size = d.size();
            while(size-- > 0)
            {
                int poll = d.pollFirst();
                if(k == 0)
                {
                    res.add(poll);
                    continue;
                }
                //将所有poll的临接边加到队列
                for(int i = he[poll]; i != -1; i = ne[i])
                {
                    int j = e[i];
                    if(!vis[j])
                    {
                        d.addLast(j);
                        vis[j] = true;
                    }
                }
            }
            k--;
        }
        return res;
    }

    //二叉树的父节点和左右孩子节点当做无向图进行建图
    void dfs1(TreeNode root)
    {
        if(root == null) return;
        if(root.left != null)
        {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs1(root.left);
        }
        if(root.right != null)
        {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs1(root.right);
        }
    }


    public List<Integer> distanceK2(TreeNode root, TreeNode t, int k)
    {
        List<Integer> res = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs1(root);
        vis[t.val] = true;
        find(t.val, k, 0, res);
        return res;
    }

    void find(int root, int max, int cur, List<Integer> res)
    {
        if(cur == max)
        {
            res.add(root);
            return;
        }
        for(int i = he[root]; i != -1; i = ne[i])
        {
            int j = e[i];
            if(!vis[j])
            {
                vis[j] = true;
                find(j, max, cur + 1, res);
            }
        }
    }
}
