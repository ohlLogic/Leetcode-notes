package com.Leetcode;

/**
 * Leetcode875,爱吃香蕉的珂珂
 * 二分
 */
public class LeetcodeDemo875 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1, r = -1;
        for(int pile : piles) r = Math.max(r, pile);
        while(l < r)
        {
            int mid = l + r >> 1;
            if(check(piles, h, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public boolean check(int[] piles, int h, int mid)
    {
        int n = piles.length, cnt = 0;
        for(int pile : piles)
        {
            cnt += (pile + mid - 1) / mid;
        }
        return cnt <= h;
    }
}
