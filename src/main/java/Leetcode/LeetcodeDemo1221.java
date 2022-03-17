package com.Leetcode;

/**
 * Leetcode1221,分隔平衡字符串
 */
public class LeetcodeDemo1221 {
    public static void main(String[] args) {
        System.out.println(balanceStringSplit("RLRRLLRLRL"));
        System.out.println(balanceStringSplit("RLLLLRRRLR"));
    }

    //贪心
    public static int balanceStringSplit(String s)
    {
        int n = s.length();
        int res = 0, coutL = 0, coutR = 0;
        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == 'R') coutR++;
            else coutL++;
            if(coutL == coutR)
            {
                res++;
                coutL = coutR = 0;
            }

        }

        return res;
    }
}
