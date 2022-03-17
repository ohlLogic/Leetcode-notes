package com.Leetcode;

/**
 * Leetcode202,快乐数
 */

import java.util.HashSet;
import java.util.Set;

public class LeetcodeDemo202 {
    public static void main(String[] args) {
        LeetcodeDemo202 tt = new LeetcodeDemo202();
        System.out.println(tt.isHappy(19));

    }
    public boolean isHappy(int n)
    {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n))
        {
            set.add(n);
            n = get(n);
        }
        return n == 1;
    }


    public int get(int n)
    {
        int res = 0;
        while(n != 0)
        {
            int r = n % 10;
            res += r * r;
            n /= 10;
        }
        return res;
    }
}
