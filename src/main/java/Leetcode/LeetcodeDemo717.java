package com.Leetcode;

/**
 * Leetcode717,1比特与2比特字符
 * 模拟
 */
public class LeetcodeDemo717 {
    public boolean isOneBitCharacter(int[] bits)
    {
        int n = bits.length;
        for(int i = 0; i < n; )
        {
            if(bits[i] == 0)
            {
                i++;
                continue;
            }
            if(bits[i] == 1 && i + 2 < n)
            {
                i += 2;
                continue;
            }
            return false;
        }
        return true;
    }
}
