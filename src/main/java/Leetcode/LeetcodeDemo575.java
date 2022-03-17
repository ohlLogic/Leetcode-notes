package com.Leetcode;

/**
 * Leetcode575,分糖果
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetcodeDemo575 {
    public int distributeCandies(int[] candyType)
    {
        int n = candyType.length;
        int m = n / 2, cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : candyType) {
            if(!map.containsKey(i)) cnt++;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if(cnt >= m) return m;
        else if(cnt < m) return cnt;
        return 1;
    }

    public int distributeCandies1(int[] candyType)
    {
        Set<Integer> set = new HashSet<>();
        for(int i : candyType) set.add(i);
        return Math.min(candyType.length / 2, set.size());
    }
}
