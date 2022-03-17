package com.Leetcode;

/**
 * Leetcode210,课程表2
 * 拓扑排序
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetcodeDemo210 {
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        //创建邻接表adjacency， 入度表indgrees
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indgrees = new int[numCourses];

        //初始化邻接表
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());

        //统计
        for(int[] tt : prerequisites)
        {
            indgrees[tt[0]]++;
            adjacency.get(tt[1]).add(tt[0]);
        }


        Deque<Integer> d = new ArrayDeque<>();

        //将所有入度为0的节点入队
        for(int i = 0; i < numCourses; i++)
        {
            if(indgrees[i] == 0) d.addLast(i);
        }

        //拓扑排序
        List<Integer> temp = new ArrayList<>();
        while(!d.isEmpty())
        {
            int poll = d.pollFirst();
            temp.add(poll);
            for(int cur : adjacency.get(poll))
            {
                if(--indgrees[cur] == 0) d.addLast(cur);
            }
        }
        if(temp.size() == numCourses)
        {
            for(int i = 0; i < numCourses; i++) indgrees[i] = temp.get(i);
            return indgrees;
        }
        return new int[0];
    }
}
