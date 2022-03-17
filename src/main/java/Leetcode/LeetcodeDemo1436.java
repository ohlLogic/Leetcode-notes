package com.Leetcode;

/**
 * Leetcode1436,旅行终点站
 * 哈希表
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetcodeDemo1436 {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
    }

    public static String destCity(List<List<String>> paths)
    {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> list : paths) map.put(list.get(0), list.get(1));

        String res = paths.get(0).get(0);
        while(map.containsKey(res)) res = map.get(res);
        return res;
    }
}
