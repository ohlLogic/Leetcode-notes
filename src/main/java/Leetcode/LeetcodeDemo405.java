package com.Leetcode;

/**
 * Leetcode405,数字转换为十六进制数
 */
public class LeetcodeDemo405 {
    public static void main(String[] args) {
        System.out.println(toHex(26));
    }

    //模拟加进制转换
    public static String toHex(int num)
    {
        if(num == 0) return "0";
        long xx = num;
        StringBuilder sb = new StringBuilder();
        if(num < 0) xx = (long) (Math.pow(2, 32) + xx);
        while(xx != 0)
        {
            long u = xx % 16;
            char c = (char) (u + '0');
            if(u >= 10) c = (char) (u - 10 + 'a');
            sb.append(c);
            xx /= 16;
        }
        return sb.reverse().toString();
    }

    //位运算+分组换算
    public static String toHex1(int num)
    {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0)
        {
            int u = num & 15;
            char c = (char) (u + '0');
            if(u >= 10) c = (char) (u - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
