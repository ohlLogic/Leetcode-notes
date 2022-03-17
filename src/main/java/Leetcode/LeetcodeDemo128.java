package com.Leetcode;

/**
 * Leetcode128,最长连续序列
 * 并查集 哈希Set
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetcodeDemo128 {
    //Set去重
    public int longestConsecttive(int[] nums)
    {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int maxLen = 0;
        for(int num : set)
        {
            //保证从左到右
            if(!set.contains(num - 1))
            {
                int curNum = num;
                int curLen = 1;

                while(set.contains(curNum + 1))
                {
                    curNum++;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    //并查集
    class UF{
        int[] p;

        public UF(int n)
        {
            //初始化并查集
            p = new int[n];
            for(int i = 0; i < n; i++) p[i] = i;
        }

        public int find(int x)
        {
            if(p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        public void union(int a, int b)
        {
            p[find(a)] = p[find(b)];
        }

        public boolean query(int a, int b)
        {
            return p[find(a)] == p[find(b)];
        }
    }

    public int longestConsecutive1(int[] nums)
    {
        int n = nums.length;
        if(n == 0) return 0;

        //并查集
        UF uf = new UF(n);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(nums[i], i);

        for(int i = 0; i < n; i++)
        {
            //如果有相连的，进行连接
            if(map.containsKey(nums[i] + 1))
            {
                int idx = map.get(nums[i] + 1);
                uf.union(i, idx);
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++)
        {
            res = Math.max(res, nums[uf.find(i)] - nums[i]);
        }
        return res + 1;
    }
}
