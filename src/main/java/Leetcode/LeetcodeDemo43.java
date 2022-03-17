package com.Leetcode;

/**
 * Leetcode43,字符串相乘
 * 高精度乘法
 */
public class LeetcodeDemo43 {
    public static void main(String[] args) {

    }
    public static String multiply(String num1, String num2)
    {
        int n = num1.length(), m = num2.length();
        int[] res = new int[n + m];
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = m - 1; j >= 0; j--)
            {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int r = a * b;
                r += res[i + j + 1];
                //取余
                res[i + j + 1] = r % 10;
                //进位
                res[i + j] += r / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n + m; i++)
        {
            if(sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
