package com.Leetcode;

/**
 * Leetcode480,滑动窗口中位数
 * 滑动窗口+双优先队列
 */

import java.util.PriorityQueue;

public class LeetcodeDemo480 {
    public static void main(String[] args) {

    }

    //双堆，滑动窗口
    public static double[] medianSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        //如果是奇数滑动窗口，right数量大于left;right是最小堆，left是最大堆，right最小堆堆顶是右半部分最小值，left堆顶是左半部分最大值
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> Integer.compare(a,b));

        for(int i = 0; i < k; i++) right.add(nums[i]);
        for(int i = 0; i < k / 2; i++) left.add(right.poll());
        res[0] = getMid(left, right);

        for(int i = k; i < n; i++)
        {
            int add = nums[i], del = nums[i - k];
            //判断add和del是在right还是left中
            if(add >= right.peek()) right.add(add);
            else left.add(add);

            if(del >= right.peek()) right.remove(del);
            else left.remove(del);

            //调整left和right
            adjust(left, right);
            res[i - k + 1] = getMid(left, right);
        }
        return res;
    }

    public static void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right)
    {
        //如果left数量大于右边，就把left堆顶元素给right
        while(left.size() > right.size()) right.add(left.poll());
        //保持right数量比left多1，如果为奇数
        while(right.size() - left.size() > 1) left.add(right.poll());
    }

    public static double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right)
    {
        //防止溢出
        if(left.size() == right.size()) return (left.peek() / 2.0) + (right.peek() / 2.0);
        else return right.peek() * 1.0;
    }
}
