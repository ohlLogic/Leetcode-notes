package com.Leetcode;

/**
 * Leetcode507,完美数
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo507 {
    public static void main(String[] args) {
        LeetcodeDemo507 tt = new LeetcodeDemo507();
        System.out.println(tt.checkPerfectNumber(1));
    }
    public boolean checkPerfectNumber(int num)
    {
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= Math.sqrt(num); i++)
        {
            int b = num / i;
            if(b * i == num)
            {
                res.add(b);
                res.add(i);
            }
        }
        int sum = -num;
        for (Integer re : res) {
            sum += re;
        }
        return num == sum;
    }
}
