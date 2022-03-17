package com.Leetcode;

/**
 * Leetcode373,查找和最小的K对数字
 * 多路归并
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetcodeDemo373 {
    //多路归并
    boolean flag = true;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {

        int n = nums1.length, m = nums2.length;
        if(n > m && !(flag = false)) return kSmallestPairs(nums2, nums1, k);

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] - nums2[b[1]]));
        //将(min(n,k), 0)形式存入优先队列
        for (int i = 0; i < Math.min(n, k); i++) q.add(new int[]{i, 0});

        while(ans.size() < k && !q.isEmpty())
        {
            int[] poll = q.poll();
            int a = poll[0], b = poll[1];
            ans.add(new ArrayList<>(){{
                add(flag ? nums1[a] : nums2[b]);
                add(flag ? nums2[b] : nums1[a]);
            }});
            //如果不够，增加下一列
            if(b + 1 < m) q.add(new int[]{a, b + 1});
        }
        return ans;
    }
}
