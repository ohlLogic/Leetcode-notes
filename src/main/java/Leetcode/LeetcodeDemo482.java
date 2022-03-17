package com.Leetcode;

/**
 * Leetcode482，格式化字符串
 * 模拟，从后向前扫描
 */
public class LeetcodeDemo482 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
        System.out.println(licenseKeyFormatting("---", 3));
    }

    public static String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        int i = n - 1, count = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (i >= 0) {
            if (count == k) {
                count = 0;
                sb.append(temp.toString().toUpperCase() + '-');
                temp.delete(0, temp.length());
            }

            if (s.charAt(i) != '-') {
                temp.append(s.charAt(i));
                count++;
            }
            i--;
        }
        sb.append(temp.toString().toUpperCase());
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }

    public static String licenseKeyFormatting1(String s, int k)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1, cnt = 0; i >= 0; i--)
        {
            if(s.charAt(i) == '-') continue;
            if(cnt == k && (cnt = 0) >= 0) sb.append("-");
            sb.append(s.charAt(i));
            cnt++;
        }
        return sb.reverse().toString().toUpperCase();
    }
}
