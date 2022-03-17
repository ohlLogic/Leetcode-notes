package com.Leetcode;

/**
 * Leetcode299,猜数字游戏
 * 模拟
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo299 {
    public String getHine(String secret, String guess)
    {
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < secret.length(); i++) map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        for(int j = 0; j < guess.length(); j++)
        {
            char c = guess.charAt(j);
            if(map.containsKey(c))
            {
                cnt++;
                int tt = map.get(c);
                if(tt - 1 == 0) map.remove(c);
                else map.put(c, tt - 1);
            }
        }

        int k = 0, res = 0;
        while(k < secret.length())
        {
            if(secret.charAt(k) == guess.charAt(k)) res++;
            k++;
        }
        return String.valueOf(res) + "A" + String.valueOf(cnt - res) + "B";
    }

    public String getHine1(String secret, String guess)
    {
        int n = secret.length();
        int a = 0, b = 0;
        int[] cnt1 = new int[10], cnt2 = new int[10];
        for(int i = 0; i < n; i++)
        {
            int c1 = secret.charAt(i) - '0', c2 = guess.charAt(i) - '0';
            if(c1 == c2) a++;
            else{
                cnt1[c1]++;
                cnt2[c2]++;
            }
        }

        for(int i = 0; i < 10; i++) b += Math.min(cnt1[i], cnt2[i]);
        return a + "A" + b + "B";
    }
}
