package com.Leetcode;

/**
 * Leetcode90,子集2
 * dfs剪枝
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeDemo90 {
    public static void main(String[] args) {
        LeetcodeDemo90 tt = new LeetcodeDemo90();
        int[] nums = {1,2,2};
        System.out.println(tt.subsetsWithDup(nums));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        dfs(nums, 0, flag);
        return res;
    }

    public void dfs(int[] nums, int u, boolean[] flag)
    {
        res.add(new ArrayList<>(list));
        if(u == nums.length) return;

        for(int i = u; i < nums.length; i++)
        {
            //剪枝，遇到同层相同节点直接跳过
            if(i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) continue;

            flag[i] = true;
            list.add(nums[i]);
            dfs(nums, i + 1, flag);
            //回溯
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    //方法二
    public List<List<Integer>> subsetsWithDup1(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs1(nums, 0, cur, res);
        return res;
    }

    void dfs1(int[] nums, int u, List<Integer> cur, List<List<Integer>> res)
    {
        int n = nums.length;
        if(n == u)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        //记录当前数值连续一段
        int last = u;
        while(last < n && nums[last] == nums[u]) last++;

        //不选择当前元素nums[u]
        dfs1(nums, last, cur, res);

        //选择当前元素nums[u]，按照抉择个数
        for(int i = u; i < last; i++)
        {
            cur.add(nums[i]);
            dfs1(nums, last, cur, res);
        }

        //回溯
        for(int i = u; i < last; i++) cur.remove(cur.size() - 1);
    }
}
