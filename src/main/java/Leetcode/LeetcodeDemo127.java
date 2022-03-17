package com.Leetcode;

/**
 * Leetcode127,单词接龙
 * 双向bfs
 */

import java.util.*;

public class LeetcodeDemo127 {
    String s, e;
    Set<String> set = new HashSet<>();
    public int ladderLength(String beginword, String endword, List<String> wordList) {
        this.s = beginword;
        this.e = endword;
        //将所有单词存入set，如果endword不在set中return
        for(String w : wordList) set.add(w);
        if(!set.contains(e)) return 0;

        //bfs
        int res = bfs();
        return res == -1 ? 0 : res + 1;
    }

    public int bfs()
    {
        //d1代表从起点beginword开始搜索（正向）
        //d2代表从终点endword开始搜索（反向）
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();

        //创建对应的哈希表，key-value：代表从开始到当前单词的转换次数
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();

        d1.add(s);
        m1.put(s, 0);
        d2.add(e);
        m2.put(e, 0);

        //双向bfs过程，当两个队列不为空才有搜索的必要
        while(!d1.isEmpty() && !d2.isEmpty())
        {
            int t = -1;
            if(d1.size() <= d2.size()) t = update(d1, m1, m2);
            else t = update(d2, m2, m1);
            if(t != -1) return t;
        }
        return -1;
    }

    public int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> other)
    {
        //获取当前需要扩展的字符串
        String poll = d.pollFirst();
        int n = poll.length();

        //枚举替换原字符串的哪个字符i
        for(int i = 0; i < n; i++)
        {
            //枚举i的替换的小写字母
            for(int j = 0; j < 26; j++)
            {
                //替换后的字符串
                String sub = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                //在set中如果有替换后字符串sub
                if(set.contains(sub))
                {
                    //如果当前字符串sub在哈希表已经被记录过，则跳过
                    if(cur.containsKey(sub)) continue;

                    //如果当前字符串在另一个方向被记录，说明找到了两个方向的最短路
                    if(other.containsKey(sub)) return cur.get(poll) + 1 + other.get(sub);
                    else{
                        //否则加入队列d
                        d.addLast(sub);
                        cur.put(sub, cur.get(poll) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
