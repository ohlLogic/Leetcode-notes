package com.Leetcode;

/**
 * Leetcode12,整数转罗马数字
 * 模拟
 */
public class LeetcodeDemo12 {
    public static void main(String[] args) {

    }

    public static String intToRoman(int x) {
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length && x > 0; i++) {
            int cv = val[i];
            String cs = str[i];
            while (x >= cv) {
                sb.append(cs);
                x -= cv;
            }
        }
        return sb.toString();

    }
}
