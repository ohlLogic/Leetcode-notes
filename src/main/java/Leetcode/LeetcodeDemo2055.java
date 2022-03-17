package com.Leetcode;

import org.junit.Test;

public class LeetcodeDemo2055 {

    @Test
    public void test(){
        int[] temp = platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}});
        for(int i = 0; i < temp.length; i++) System.out.println(temp[i]);

    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int m = queries.length, n = s.length();
        char[] cs = s.toCharArray();

        //1.创建前缀数组sum，sum[i]表示cs[0...i]之间盘子的数目
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (cs[i - 1] == '*' ? 1 : 0);

        //2.check
        int[] ans = new int[m];
        int idx = 0;
        for(int i = 0; i < m; i++)
        {
            int l = queries[i][0], r = queries[i][1];
            //双指针查询
            while(l < r && cs[l] == '|') l++;
            while(l < r && cs[r] == '|') r--;


            //查询sum数组
            int cur = sum[r + 1] - sum[l];
            ans[idx++] = cur;

        }
        return ans;
    }
}
