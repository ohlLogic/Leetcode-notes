package com.Leetcode;

/**
 * Leetcode537,复数乘法
 * 模拟
 */
public class LeetcodeDemo537 {
    public String complexNumberMultiply(String num1, String num2)
    {
        String[] ss1 = num1.split("\\+i"), ss2 = num2.split("\\+i");
        int a = parse(ss1[0]), b = parse(ss2[1]);
        int c = parse(ss2[0]), d = parse(ss2[1]);
        int A = a * c - b * d, B = b * c + a * d;
        return A + "+" + B + "i";
    }

    public int parse(String s)
    {
        return Integer.parseInt(s);
    }
}
