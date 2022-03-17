package com.Leetcode;

/**
 * Leetocde38,外观数组
 * 模拟
 */
public class LeetcodeDemo38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    //模拟
    public static String countAndSay(int n)
    {
        String s = "1";
        for(int i = 2; i <= n; i++) s = getnext(s);
        return s;
    }
    public static String getnext(String s)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0, sum = 0;
        char val = s.charAt(i);
        while(i < s.length())
        {
            if(s.charAt(i) == val) sum++;
            else{
                sb.append(sum);
                sb.append(s.charAt(i - 1));
                sum = 1;
                val = s.charAt(i);
            }
            i++;
        }
        sb.append(sum);
        sb.append(s.charAt(i - 1));
        return sb.toString();
    }
}
