package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LeetcodeDemo220 {
    long size;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
    }

    //滑动窗口+红黑树
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for(int i = 0; i < n; i++)
        {
            Long u = nums[i] * 1L;
            Long l = ts.floor(u);
            Long r = ts.ceiling(u);
            if(l != null && u - l <= t)return true;
            if(r != null && r - u <= t)return true;
            ts.add(u);
            if(i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;
    }

    //桶排序
    public  boolean containsNearbyAlomstDuplicate(int[] nums, int k, int t)
    {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i] * 1L;
            long idx = getInx(u);
            if(map.containsKey(idx)) return true;
            long l = idx - 1, r = idx + 1;
            if(map.containsKey(l) && u - map.get(l) <= t) return true;
            if(map.containsKey(r) && map.get(r) - u <= t) return true;
            map.put(idx, u);
            if(i >= k) map.remove(getInx(nums[i - k] * 1L));
        }
        return false;
    }

    public long getInx(long u)
    {
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }
}
