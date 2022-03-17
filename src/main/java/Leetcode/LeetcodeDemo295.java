package com.Leetcode;

/**
 * Leetcode295,数据流的中位数
 * 双堆对顶
 */

import java.util.*;
public class LeetcodeDemo295 {
    PriorityQueue<Integer> A, B;
    public LeetcodeDemo295()
    {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num)
    {
        if(A.size() != B.size())
        {
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian()
    {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
