package com.Leetcode;

/**
 * Leetcode233,数字1的个数
 * 数位DP，模拟
 */
public class LeetcodeDemo233 {
    public static void main(String[] args) {
        System.out.println(countDigitOne1(10));
    }

    //不断去除末尾的1，超时
    public static int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += get(i);
        }
        return res;
    }

    public static int get(int i)
    {
        int res = 0;
        while (i > 0) {
            int r = i % 10;
            if (r == 1) res++;
            i /= 10;
        }
        return res;
    }

    //计算类模拟
    public static int countDigitOne1(int n)
    {
        String s = String.valueOf(n);
        int m = s.length();
        if(m == 1) return n > 0 ? 1 : 0;

        //前缀和后缀数组
        int[] ps = new int[m], ss = new int[m];
        for(int i = 1; i < m - 1; i++)
        {
            ps[i] = Integer.parseInt(s.substring(0, i));
            ss[i] = Integer.parseInt(s.substring(i + 1));
        }
        ss[0] = Integer.parseInt(s.substring(1));
        ps[m - 1] = Integer.parseInt(s.substring(0, m - 1));

        int res = 0;
        for(int i = 0; i < m; i++)
        {
            //len表示当前位之后长度
            int tmp = s.charAt(i) - '0', len = m - i - 1;
            int pre = ps[i], suf = ss[i];
            int tt = 0;
            tt += pre * Math.pow(10, len);
            if(tmp == 0){}
            else if(tmp == 1) tt += suf + 1;
            else tt += Math.pow(10, len);
            res += tt;
        }
        return res;
    }

}
