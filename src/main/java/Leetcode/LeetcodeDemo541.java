package com.Leetcode;

/**
 * Leetcode541,反转字符串2
 *
 */
public class LeetcodeDemo541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcd", 2));
    }

    public static String reverseStr(String s, int k)
    {
        char[] cs = s.toCharArray();
        int cnt = 0, n = s.length(), index = -1;
        for(int i = 0; i < n; i++)
        {
            cnt++;
            if(cnt == 2 * k)
            {
                cnt = 0;
                reverse(cs, index + 1, index + k);
                index = i;
            }
        }
        if(cnt > 0 && cnt < k) reverse(cs, index + 1, n - 1);
        else if(cnt >= k && cnt < 2 * k) reverse(cs, index + 1, index + k);
        return String.valueOf(cs);
    }

    public static void reverse(char[] cs, int l, int r)
    {
        while(l < r)
        {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }

    //方法更好
    public static String reverseStr1(String s, int k)
    {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for(int l = 0; l < n; l = l + 2 * k)
        {
            int r = l + k - 1;
            reverse(cs, l, Math.min(r, n - 1));
        }
        return String.valueOf(cs);
    }
}
