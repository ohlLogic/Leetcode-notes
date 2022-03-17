package com.Leetcode;

/**
 * Leetcode492,构造矩形
 * 模拟
 */
public class LeetcodeDemo492 {
    public static void main(String[] args) {

    }

    public int[] constructRectangle(int area)
    {
        for(int i = (int) (Math.sqrt(area)); ; i--)
        {
            if(area % i == 0) return new int[]{area / i, i};
        }
    }
}
