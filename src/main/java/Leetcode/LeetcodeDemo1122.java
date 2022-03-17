package com.Leetcode;

/**
 * Leetcode1122,数组的相对排序
 * 计数排序
 */

import java.util.*;

public class LeetcodeDemo1122 {
    //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2)
    {
        int[] ans = new int[arr1.length];
        int[] frequency = new int[1001];
        for(int i : arr1) frequency[i]++;

        //遍历arr2顺序
        int idx = 0;
        for(int i : arr2)
        {
            for(int j = 0; j < frequency[i]; j++)
            {
                ans[idx++] = i;
            }
            //清空
            frequency[i] = 0;
        }

        //将剩下的加入ans
        for(int i = 0; i < 1001; i++)
        {
            for(int j = 0; j < frequency[i]; j++)
            {
                ans[idx++] = i;
            }
        }
        return ans;
    }

    //自定义排序
    public int[] relativeSortArray1(int[] arr1, int[] arr2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);

        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });

        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
}
