package com.Leetcode;

/**
 * Leetcode981,基于时间的键值存储
 * 二分+设计题
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo981 {
    public static void main(String[] args) {

    }

}
// 哈希表套数组方式
class TimeMap{
    class Node{
        String k, v;
        int t;
        Node(String _k, String _v, int _t)
        {
            k = _k;
            v = _v;
            t = _t;
        }
    }
    Map<String, List<Node>> map = new HashMap<>();
    public TimeMap()
    {

    }

    public void set(String key, String value, int timestamp)
    {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Node(key, value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp)
    {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        if(list.isEmpty()) return "";
        int n = list.size();
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(list.get(mid).t <= timestamp) l = mid;
            else r = mid - 1;
        }
        return list.get(r).t <= timestamp ? list.get(r).v : "";
    }
}
