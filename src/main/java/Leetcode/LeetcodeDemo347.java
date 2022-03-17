package com.Leetcode;

/**
 * Leetcode347,前K个高频元素
 */

import java.util.*;
import java.util.stream.IntStream;

public class LeetcodeDemo347 {
    class Pair
    {
        int num;
        int freq;
        Pair(int num, int freq)
        {
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k)
    {
        //统计每个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        Pair[] pairs = IntStream.of(nums).distinct().boxed().map(num -> new Pair(num, map.get(num))).toArray(Pair[]::new);

        Pair[] topK = quickSelect(pairs, 0, pairs.length - 1, k - 1);


        //构造答案
        int[] res = new int[topK.length];
        int idx = 0;
        for(Pair pair : topK) res[idx++] = pair.num;
        return res;
    }

    public Pair[] quickSelect(Pair[] pairs, int l, int r, int k)
    {
        int j = Partition(pairs, l, r);
        if(j == k) return Arrays.copyOf(pairs, j + 1);

        return j < k ? quickSelect(pairs, j + 1, r, k) : quickSelect(pairs, l, j, k);
    }

    public int Partition(Pair[] pairs, int l, int r)
    {
        Pair x = pairs[l + r >> 1];
        int i = l - 1, j = r + 1;
        while(i < j)
        {
            do i++; while(pairs[i].freq > x.freq);
            do j--; while(pairs[j].freq < x.freq);
            if(i < j)
            {
                Pair temp = pairs[i];
                pairs[i] = pairs[j];
                pairs[j] = temp;
            }
        }
        return j;
    }


    //小根堆
    public int[] topKFrequent1(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);


        //小根堆
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        map.forEach((num, cnt) ->{
            if(pq.size() < k) pq.offer(num);
            else if(map.get(pq.peek()) < cnt)
            {
                pq.poll();
                pq.offer(num);
            }
                });
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num: pq) {
            res[idx++] = num;
        }
        return res;
    }
    //quick_sort(nums, 0, nums.length - 1)
    public void quick_sort(int[] nums, int l, int r)
    {
        if(l >= r) return;

        //切分
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while(i < j)
        {
            do i++; while(nums[i] < x);
            do j--; while(nums[j] > x);
            if(i < j)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        //分治
        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }
}
