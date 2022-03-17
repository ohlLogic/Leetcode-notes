package com.Leetcode;

/**
 * Leetcode451,根据字符出现频率排序
 * 哈希表 + comparetor
 */

import java.util.*;

public class LeetcodeDemo451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }

    //hashmap + 比较器comparetor
    public static String frequencySort(String s)
    {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);


        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        Iterator<Map.Entry<Character, Integer>> iter = list.iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext())
        {
            Map.Entry<Character, Integer> next = iter.next();
            char c = next.getKey();
            int len = next.getValue();
            while(len > 0)
            {
                sb.append(c);
                len--;
            }
        }
        return sb.toString();
    }

    //数组实现 + 模拟
    public static String frequencySort1(String s)
    {
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();

        for (int i = 0; i < 128; i++) {
            cnts[i][0] = i;
        }
        for(char c : cs) cnts[c][1]++;
        Arrays.sort(cnts, (a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 128; i++)
        {
            char c = (char) cnts[i][0];
            int k = cnts[i][1];
            while(k-- > 0) sb.append(c);
        }
        return sb.toString();
    }
}
