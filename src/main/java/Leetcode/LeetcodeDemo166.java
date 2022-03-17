package com.Leetcode;

/**
 * Leetocde166,分数到小数
 * 竖式除法模拟
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo166 {
    public static void main(String[] args) {

    }
    public static String fractionToDecimal(int numerator, int demoninator)
    {
        long a = numerator, b = demoninator;
        if(a % b == 0) return String.valueOf(a / b);
        StringBuilder sb = new StringBuilder();
        if(a * b < 0) sb.append('-');
        a = Math.abs(a); b = Math.abs(b);

        sb.append(String.valueOf(a / b) + '.');
        a %= b;

        Map<Long, Integer> map = new HashMap<>();
        while(a != 0)
        {
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if(map.containsKey(a))
            {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
