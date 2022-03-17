package com.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo260 {
    //哈希表
    public int[] singerNumber(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int[] res = new int[2];
        int idx = 0;
        for(int i : nums)
        {
            if(map.get(i) == 1) res[idx++] = i;
        }
        return res;
    }

    //位运算：异或
    public int[] singerNumber1(int[] nums)
    {
        int xor = 0;
        for(int num : nums) xor ^= num;

        //最右边的1
        int bit = xor & (-xor);

        int x = 0, y = 0;
        for(int num : nums)
        {
            if((num & bit) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}
