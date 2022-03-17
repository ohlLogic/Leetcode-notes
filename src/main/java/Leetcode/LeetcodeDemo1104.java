package com.Leetcode;

/**
 * Leetcode1104,二叉树寻路
 *
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo1104 {
    int getStart(int level) {
        return (int) Math.pow(2, level - 1);
    }
    int getEnd(int level)
    {
        return (int) Math.pow(2, level) - 1;
    }
    public static void main(String[] args) {

    }
    //模拟
    public  List<Integer> pathInZigZagTree(int n)
    {
        int level = 1;
        while(getEnd(level) < n) level++;

        int[] res = new int[level];
        //idx代表从label节点到祖先节点的顺序，cur表示当前的值
        int idx = level - 1, cur = n;
        while(idx >= 0)
        {
            res[idx--] = cur;
            //当前层数有多少个节点
            int tot = (int) Math.pow(2, level - 1);
            int start = getStart(level), end = getEnd(level);

            //如果当前level是偶数层，那么当前节点从右向左递增，相应地计算上一层下标也应该从右向左
            if(level % 2== 0)
            {
                //当前层的上一层数量，
                int j = tot / 2;
                //找到当前节点
                for(int i = start; i <= end; i += 2, j--)
                {
                    if(i == cur || (i + 1) == cur) break;
                }
                int preStart = getStart(level - 1);
                while(j-- > 1) preStart++;
                cur = preStart;
            }
            else
            {
                int j = 1;
                for(int i = start; i <= end; i += 2, j++)
                {
                    if(cur == i || (i + 1) == cur) break;
                }
                int preEnd = getEnd(level - 1);
                while(j-- > 1) preEnd--;
                cur = preEnd;
            }
            level--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i : res) list.add(i);
        return list;
    }

    //数学规律
    public List<Integer> pathInZigZagTree1(int n)
    {
        int level = 1;
        while(getEnd(level) < n) level++;

        int[] res = new int[level];
        //idx代表从label节点到祖先节点的顺序，cur表示当前的值
        int idx = level - 1, cur = n;
        while(idx >= 0)
        {
            res[idx--] = cur;
            level--;
            cur = getStart(level) + getEnd(level) - cur / 2;
        }
        List<Integer> list = new ArrayList<>();
        for(int i : res) list.add(i);
        return list;
    }
}
