package com.Leetcode;

public class LeetcodeDemo65 {
    public static void main(String[] args) {

    }

    //模拟
    public static boolean isNumber(String s)
    {
        int n = s.length();
        char[] cs = s.toCharArray();
        int idx = -1;
        for(int i = 0; i < n; i++)
        {
            if(cs[i] == 'e' || cs[i] == 'E')
            {
                if(idx == -1) idx = i;
                else return false;
            }
        }

        boolean res = true;
        if(idx != -1)
        {
            res &= check(cs, 0, idx - 1, false);
            res &= check(cs, idx + 1, n - 1,true);
        }
        else res &= check(cs, 0, n - 1, false);
        return res;
    }

    public static boolean check(char[] cs, int start, int end, boolean mustInteger)
    {
        if(start > end) return false;
        if(cs[start] == '+' || cs[start] == '-') start++;
        boolean hasDot = false, hasNum = false;
        for(int i = start; i <= end; i++)
        {
            if(cs[i] == '.')
            {
                if(mustInteger || hasDot) return false;
                hasDot = true;
            }
            else if(cs[i] >= '0' && cs[i] <= '9') hasNum = true;
            else return false;
        }
        return hasNum;
    }
}
