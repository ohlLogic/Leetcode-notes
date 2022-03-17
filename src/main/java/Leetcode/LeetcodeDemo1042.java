package com.Leetcode;

/**
 * Leetcode1042, 不邻接植花
 */
public class LeetcodeDemo1042 {
    public int[] gardenNoAdj(int n, int[][] paths)
    {
        int[][] topo = new int[n + 1][3];

        //建图
        for(int[] path : paths)
        {
            int temp = 0;
            while(topo[path[0]][temp] != 0) temp++;
            topo[path[0]][temp] = path[1];
            temp = 0;
            while(topo[path[1]][temp] != 0) temp++;
            topo[path[1]][temp] = path[0];
        }

        int[] res1 = new int[n + 1];
        int[] res = new int[n];
        for(int i = 1; i <= n; i++)
        {
            int temp = 1;
            while(res1[topo[i][0]] == temp || res1[topo[i][1]] == temp || res1[topo[i][2]] == temp) temp++;
            res1[i] = temp;
        }
        for(int i = 0; i < n; i++) res[i] = res1[i + 1];
        return res;
    }
}
