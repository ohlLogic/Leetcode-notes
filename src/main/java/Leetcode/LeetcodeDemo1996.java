package com.Leetcode;

/**
 * Leetcode1996,游戏中弱角色的数量
 * 排序
 */

import java.util.Arrays;

public class LeetcodeDemo1996 {
    //计数排序
    public int numberOfWeakCharacters(int[][] ps)
    {
        int n = ps.length, ans = 0;
        Arrays.sort(ps, (a, b) ->{
            if(a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for(int i = 0, max = ps[0][1]; i < n;)
        {
            //处理连续一段
            int j = i;
            while(j < n && ps[i][0] == ps[j][0])
            {
                if(i != 0 && ps[j][1] < max) ans++;
                j++;
            }
            //维护上一段连续最大防御值
            max = Math.max(max, ps[i][1]);
            i = j;
        }
        return ans;
    }
}
