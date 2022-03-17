package com.Leetcode;

/**
 * Leetcode207,课程表
 * 拓扑排序
 */

import java.util.*;

public class LeetcodeDemo207 {
    //拓扑排序 + BFS
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        //建立入度表indegrees, 邻接表adjacency
        int[] indegress = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();

        //队列d
        Deque<Integer> d = new ArrayDeque<>();

        //邻接表初始化
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());

        //统计
        for(int[] tt : prerequisites)
        {
            //统计入度
            indegress[tt[0]]++;
            adjacency.get(tt[1]).add(tt[0]);
        }

        //将入度为0的节点加入队列d
        for(int i = 0; i < numCourses; i++)
        {
            if(indegress[i] == 0) d.addLast(i);
        }

        //拓扑排序
        while(!d.isEmpty())
        {
            int poll = d.pollFirst();
            numCourses--;
            //遍历该点的邻接表
            for(int cur : adjacency.get(poll))
            {
                if(--indegress[cur] == 0) d.addLast(cur);
            }
        }
        return numCourses == 0;
    }

    //DFS判断图中是否有环
    public boolean canFinish1(int numCourses, int[][] prerequisites)
    {
        //创建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        //初始化邻接表
        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for(int[] tt : prerequisites) adjacency.get(tt[1]).add(tt[0]);
        //标志位
        int[] flag = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
        {
            //如果有环，dfs ->return false
            if(!dfs(adjacency, flag, i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flag, int i)
    {
        if(flag[i] == 1) return false;
        if(flag[i] == -1) return true;
        flag[i] = 1;
        for(Integer j : adjacency.get(i))
        {
            if(!dfs(adjacency, flag, j)) return false;
        }
        flag[i] = -1;
        return true;
    }
}
