package com.Leetcode;

/**
 * Leetcode825,适龄的朋友
 */

import java.util.Arrays;

public class LeetcodeDemo825 {
    //排序+双指针
    public int numFriendRequests(int[] ages)
    {
        Arrays.sort(ages);
        int n = ages.length, ans = 0;
        for (int k = 0, i = 0, j = 0; k < n; k++) {
            //找到左边界
            while (i < k && !check(ages, i, k)) i++;
            //找到由边界
            if (j < k) j = k;
            while (j < n && check(ages, j, k)) j++;
            if (j > i) ans += j - i - 1;
        }
        return ans;
    }

    public boolean check(int[] ages, int i, int j)
    {
        if((ages[j] <= 0.5 * ages[i] + 7) || (ages[j] > ages[i]) || (ages[j] > 100 && ages[i] < 100)) return false;
        return true;
    }

    //桶排序+前缀和
    int N = 130;
    public int numFriendRequests1(int[] ages)
    {
        int[] nums = new int[N];
        for(int i : ages) nums[i]++;
        //前缀和
        for(int i = 1; i < N; i++) nums[i] += nums[i - 1];

        int ans = 0;
        for(int y = 1, x = 1; y < N; y++)
        {
            //a个y
            int a = nums[y] - nums[y - 1];
            if(a == 0) continue;
            if(x < y) x = y;
            while(x < N && check1(x, y)) x++;
            //[y,x)范围
            int b = nums[x - 1] - nums[y - 1] - 1;
            if(b > 0) ans += b * a;
        }
        return ans;
    }
    public boolean check1(int x, int y)
    {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;

    }
}
