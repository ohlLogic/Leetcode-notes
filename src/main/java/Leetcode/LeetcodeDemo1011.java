package com.Leetcode;

/**
 * Leetcode1011,在D天内送达包裹的能力
 * 二分
 */
public class LeetcodeDemo1011 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        LeetcodeDemo1011 tt = new LeetcodeDemo1011();
        System.out.println(tt.shipWithinDays(weights, 5));
    }

    public int shipWithinDays(int[] weights, int days)
    {
        int n = weights.length;
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        int l = max, r = sum;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(check(weights, mid, days)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public boolean check(int[] weights, int mid, int days)
    {
        int n = weights.length;
        int cnt = 1;
        for(int i = 1, sum = weights[0]; i < n; sum = 0, cnt++)
        {
            while(i < n && sum + weights[i] <= mid)
            {
                sum += weights[i];
                i++;
            }
        }
        return cnt - 1 <= days;
    }
}
