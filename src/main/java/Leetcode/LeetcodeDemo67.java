package com.Leetcode;

/**
 * Leetcode67：二进制加法，返回一个二进制数
 */
public class LeetcodeDemo67 {
    public static void main(String[] args) {
        //System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary1("1010", "1011"));



    }

    public static String addBinary(String a, String b) {
        return Long.toBinaryString(getLong(a) + getLong(b));
    }

    public static long getLong(String a)
    {
        long sum = 0;
        char[] aa = a.toCharArray();
        for(int i = aa.length - 1; i >= 0; i--)
        {
            sum += (aa[i] - '0') * Math.pow(2, aa.length - 1 - i);
        }

        return sum;
    }

    public static int getInt(String a, int index)
    {
        if(index < 0) return 0;
        return a.charAt(index) - '0';
    }

    public static String addBinary1(String a, String b)
    {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while(i >= 0 || j >= 0 || carry != 0)
        {
            //从后向前扫描，若当前位相加大于等于2，则进1，否则不变
            int sum = getInt(a, i) + getInt(b, j) + carry;
            if(sum < 2)
            {
                carry = 0;
                stringBuilder.append((char)(sum + '0'));
            }else{
                stringBuilder.append((char) (sum % 2 + '0'));
                carry = sum / 2;
            }

            i --;
            j --;
        }
        return stringBuilder.reverse().toString();
    }
}
