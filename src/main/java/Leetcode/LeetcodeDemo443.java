package com.Leetcode;

/**
 * Leetcode443,压缩字符串
 * 三指针模拟
 */
public class LeetcodeDemo443 {
    public static void main(String[] args) {
        char[] chars = {'a', 'b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars)
    {
        int n = chars.length;
        if(n == 1) return 1;
        int k = 0;
        for(int i = 0; i < n;)
        {
            int j = i;
            while(j < n && chars[i] == chars[j]) j++;

            chars[k++] = chars[i];
            if(j - i > 1)
            {
                String s = String.valueOf(j - i);
                int t = 0;
                while(t < s.length()) chars[k++] = s.charAt(t++);
            }
            i = j;
        }

        return k;
    }
}
