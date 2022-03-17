package com.Leetcode;

/**
 * Leetcode1052,爱生气的书店老板
 */
public class LeetcodeDemo1052 {
    public static void main(String[] args) {

    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes)
    {
        int n = customers.length;
        //1.将原本满意的用户加入答案
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            if(grumpy[i] == 0)
            {
                res += customers[i];
                customers[i] = 0;
            }
        }

        //2.在customers中找到一段连续长度为minutes的子数组，使得总和最大
        int max = 0, cur = 0;
        for(int i = 0, j = 0; i < n; i++)
        {
            cur += customers[i];
            if(i - j + 1 > minutes) cur -= customers[j++];
            max = Math.max(max, cur);
        }
        return max + res;
    }
}
