package com.Leetcode;

/**
 * Leetcode415,字符串相加
 */

public class LeetcodeDemo415 {
    public String addString(String num1, String num2)
    {
        int carry = 0, n = num1.length(), m = num2.length();
        StringBuilder sb = new StringBuilder();
        int i = n - 1, j = m - 1;
        while(i >= 0 || j >= 0 || carry != 0)
        {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + carry;
            sb.append(res % 10);
            carry = res / 10;
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
