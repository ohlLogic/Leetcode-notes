package com.Leetcode;

/**
 * Leetcode1764,通过连接另一个数组的子数组得到一个数组
 */
public class LeetcodeDemo1764 {
    public static void main(String[] args) {

    }

    public static boolean canChoose(int[][] groups, int[] nums)
    {
        int n = groups.length, m = nums.length;
        int cnt = 0;
        for(int i = 0, j = 0; i < m && j < n;)
        {
            //代表从nums[i]开始匹配groups[j]
            if(check(groups[j], nums, i))
            {
                cnt++;
                //下次匹配从该段之后
                i += groups[j++].length;
            }
            else i++;
        }
        return cnt == n;
    }

    public static boolean check(int[] g, int[] nums, int i)
    {
        int j = 0;
        for(; j < g.length && i < nums.length; i++, j++)
        {
            if(g[j] != nums[i]) return false;
        }
        return j == g.length;
    }
}
