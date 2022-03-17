package com.Leetcode;

/**
 * Leetcode1078,Bigram分词
 * 模拟
 */

import java.util.*;
public class LeetcodeDemo1078 {
    public String[] findOcurrences(String text, String a, String b)
    {
        String[] ss = text.split(" ");
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; i++) {
            if (ss[i].equals(a) && ss[i + 1].equals(b)) list.add(ss[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }
}
