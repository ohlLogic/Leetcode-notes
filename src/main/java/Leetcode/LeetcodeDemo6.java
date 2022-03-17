package com.Leetcode;

import java.util.ArrayList;

public class LeetcodeDemo6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    //按行排序
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        ArrayList<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < Math.min(s.length(), numRows); i++)
        {
            list.add(new StringBuilder());
        }

        int cur = 0;
        boolean godown = false;

        for(char c : s.toCharArray())
        {
            list.get(cur).append(c);
            if(cur == 0 || cur == numRows - 1) godown = !godown;
            cur += godown ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
