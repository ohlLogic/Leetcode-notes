package com.Leetcode;

/**
 * Leetcode1482, 制作m束花所需的最少天数
 * 二分
 */
public class LeetcodeDemo1482 {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        LeetcodeDemo1482 test = new LeetcodeDemo1482();
        System.out.println(test.minDays(bloomDay, 3, 1));
    }

    public int minDays(int[] bloomDay, int m, int k)
    {
        int n = bloomDay.length;
        if(n < m * k) return - 1;
        int r = bloomDay[0];
        for(int i = 1; i < n; i++) r = Math.max(r, bloomDay[i]);

        int l = 0;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(check(mid, bloomDay, k, m)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public boolean check(int mid, int[] bloomDay, int k, int m)
    {
        int n = bloomDay.length;
        int cnt = 0;

        for(int i = 0; i < n && cnt < m;)
        {
            int cur = bloomDay[i] <= mid ? 1 : 0, j = i;
            if(cur > 0)
            {
                while(cur < k && j + 1 < n && bloomDay[j + 1] <= mid)
                {
                    j++;
                    cur++;
                }
                if(cur == k) cnt++;
                i = j + 1;
            }
            else i++;
        }
        return cnt >= m;
    }
}
