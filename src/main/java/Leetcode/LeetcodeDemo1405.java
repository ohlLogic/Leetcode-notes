package com.Leetcode;

/**
 * Leetcode1405,最长快乐字符串
 * 贪心
 */

import java.util.PriorityQueue;

public class LeetcodeDemo1405 {
    public String longestDiverseString(int a, int b, int c)
    {
        //将a,b,c三个字符(数量大于0)存入大根堆
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if(a > 0) q.add(new int[]{0, a});
        if(b > 0) q.add(new int[]{1, b});
        if(c > 0) q.add(new int[]{2, c});

        /**
         * 尝试用最多的字符进行构造，如果当前大根堆最多的字符跟前两个字符构成“xxx”
         * 则采用次多的元素进行构造
         */
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
        {
            int[] poll = q.poll();
            //当前sb长度
            int n = sb.length();
            char ch = (char) (poll[0] + 'a');
            if(n >= 2 && sb.charAt(n - 1) == ch && sb.charAt(n - 2) == ch)
            {
                if(q.isEmpty()) break;
                //加入次多的元素
                int[] next = q.poll();
                sb.append((char)(next[0] + 'a'));
                //如果次多的元素没用用完则，加入大根堆
                if(--next[1] != 0) q.add(next);
                //加入最多的元素
                q.add(poll);
            }else{
                sb.append(ch);
                if(--poll[1] != 0) q.add(poll);
            }
        }
        return sb.toString();
    }
}
