package com.Leetcode;

/**
 * Leetcode1893,检查是否区域所有整数都被覆盖
 *
 */
public class LeetcodeDemo1893 {
    public static void main(String[] args) {
        int[][] range = {{1,10}, {10,20}};
        System.out.println(isCovered(range, 21, 21));
    }

    public static boolean isCovered(int[][] ranges, int left, int right)
    {
        boolean res = true;
        for(int i = left; i <= right; i++)
        {
            res &= check(ranges, i);
        }

        return res;
    }

    public static boolean check(int[][] ranges, int k)
    {
        int n = ranges.length;
        for(int i = 0; i < n; i++)
        {
            if(ranges[i][0] <= k && ranges[i][1] >= k) return true;
        }
        return false;
    }

    //差分数组+前缀和
    public static boolean isCoverd(int[][] ranges, int left, int right)
    {
        int[] diff = new int[52];
        for(int i = 0; i < ranges.length; i++)
        {
            diff[ranges[i][0]]++;
            diff[ranges[i][1] + 1]--;
        }

        int[] sum = new int[52];
        for(int i = 1; i <= 51; i++) sum[i] = sum[i - 1] + diff[i];

        for(int i = left; i <= right; i++)
        {
            if(sum[i] <= 0) return false;
        }
        return true;
    }
}
