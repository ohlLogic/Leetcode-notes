package com.Leetcode;

/**
 * Leetcode838,推多米诺
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo838 {
    //BFS
    public String pushDominoes(String dominoes)
    {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        /**
         * d中表示不为'.'的骨牌，(loc,time,dire)三元组为：位置loc的骨牌在time时刻收到方向dire的力
         */
        Deque<int[]> d = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            if(cs[i] == '.') continue;
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }

        //BFS过程
        while(!d.isEmpty())
        {
            int[] info = d.pollFirst();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            if(cs[loc] == '.' || (ne < 0 || ne >= n)) continue;
            if(g[ne] == 0) //首次受力
            {
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            }
            else if(g[ne] == time + 1) //多次受力
            {
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }

    //双指针
    public String pushDominoes1(String dominoes)
    {
        //预处理将dominoes左边加上'L'，右边加上'R'
        dominoes = new StringBuilder("L").append(dominoes).append('R').toString();

        StringBuilder ans = new StringBuilder();
        int l = 0, r = 1, n = dominoes.length();
        while(r < n)
        {
            //找到右边最近受力点
            while(r < n && dominoes.charAt(r) == '.') r++;
            char leftchar = dominoes.charAt(l), rightchar = dominoes.charAt(r);
            //如果两段连续LL或者RR直接填满中间字符
            if(leftchar == rightchar)
            {
                for(int i = l + 1; i < r; i++) ans.append(leftchar);
            }
            else if(leftchar == 'R') //R...L情况需要向中间靠拢
            {
                for(int i = 0; i < (r - l - 1) / 2; i++) ans.append('R');
                if((r - l + 1) % 2 == 1) ans.append('.');//奇数情况
                for(int i = 0; i < (r - l - 1) / 2; i++) ans.append('L');
            }
            else{
                for(int i = l + 1; i < r; i++) ans.append('.');
            }
            ans.append(rightchar);
            l = r;
            r++;
        }
        return ans.substring(0, ans.length() - 1).toString();
    }

}
