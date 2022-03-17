package com.Leetcode;

/**
 * Leetcode1557,可以到达所有点的最少点树木
 *
 */

import java.util.*;
public class LeetcodeDemo1557 {
    public List<Integer> findSamllSetOfVertices(int n, List<List<Integer>> edges)
    {
        //寻找入度为0的节点
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set= new HashSet<>();

        //将所有路径终点放入set，那么没有进入set的节点就是入度为0的节点
        for(List<Integer> edge : edges)
        {
            set.add(edge.get(1));
        }

        for(int i = 0; i < n; i++)
        {
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}
