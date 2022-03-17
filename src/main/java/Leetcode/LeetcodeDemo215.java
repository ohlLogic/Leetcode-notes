package com.Leetcode;

/**
 * Leetcode215,数组中的第k个最大元素
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetcodeDemo215 {
    //排序
    public int findKthLargest(int[] nums, int k)
    {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }

    //基于快排思想
    public int findKthLargest1(int[] nums, int k)
    {
        int n = nums.length;
        int left = 0, right = n - 1;
        int target = n - k;

        while(true)
        {
            int idx = partition(nums, left, right);
            if(idx == target) return nums[idx];
            else if(idx < target) left = idx + 1;
            else right = idx - 1;
        }
    }

    public int partition(int[] nums, int left, int right)
    {
        int pivot = nums[left];
        int j = left;
        for(int i = left + 1; i <= right; i++)
        {
            if(nums[i] < pivot)
            {
                //j初值为left，先右移，小于pivot的元素都被交换到后面
                j++;
                swap(nums, j, i);
            }
        }
        //之前nums[left+1, j] < pivot
        swap(nums, j, left);
        return j;
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //优先队列
    public int findKthLargest2(int[] nums, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums)
        {
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
