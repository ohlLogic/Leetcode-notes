package com.Leetcode;

/**
 * Leetcode229,求众数2
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo229
{
    public static void main(String[] args) {

    }

    //哈希表
    public List<Integer> majorityElement(int[] nums)
    {
        int n = nums.length;
        int m = (int) Math.floor(n / 3) + 1;
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (Integer integer : map.keySet()) {
            if(map.get(integer) >= m) res.add(integer);
        }
        return res;
    }

    //摩尔投票
    public List<Integer> majorityElement2(int[] nums)
    {
        int n = nums.length;
        //候选者
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for(int i : nums)
        {
            if(c1 != 0 && a == i) c1++;
            else if(c2 != 0 && b == i) c2++;
            else if(c1 == 0 && ++c1 >= 0) a = i;
            else if(c2 == 0 && ++c2 >= 0) b = i;
            else
            {
                c1--;c2--;
            }
        }
        c1 = 0; c2 = 0;
        for(int i : nums)
        {
            if(a == i) c1++;
            else if(b == i) c2++;
        }
        List<Integer> res = new ArrayList<>();
        if(c1 > n / 3) res.add(a);
        if(c2 > n / 3) res.add(b);
        return res;
    }
}
