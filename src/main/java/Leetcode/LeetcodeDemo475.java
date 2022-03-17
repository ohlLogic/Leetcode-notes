package com.Leetcode;

/**
 * Leetcode475,供暖器
 * 二分
 */

import java.util.Arrays;

public class LeetcodeDemo475 {
    public int findRadius(int[] houses, int[] heaters)
    {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int l = 0, r = (int) 1e9;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(check(houses, heaters, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public boolean check(int[] houses, int[] headters, int x)
    {
        int n = houses.length, m = headters.length;
        for(int i = 0, j = 0; i < n; i++)
        {
            while(j < m && houses[i] > headters[j] + x) j++;
            if(j < m && headters[j] - x <= houses[i] && headters[j] + x >= houses[i]) continue;
            return false;
        }
        return true;
    }
}
