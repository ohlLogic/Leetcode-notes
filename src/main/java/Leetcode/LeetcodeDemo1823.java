package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1823，找出游戏的获胜者
 * 约瑟夫环
 */
public class LeetcodeDemo1823 {
    public int findTheWinner(int n, int k)
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);

        int idx = 0;
        //模拟
        while(list.size() != 1)
        {
            //当前应该删除的下标
            idx = (idx + k - 1) % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }
}
