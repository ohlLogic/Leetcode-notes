package com.Leetcode;

/**
 * Leetcode374,猜数字大小
 * 二分
 */
public class LeetcodeDemo374 {
    public static void main(String[] args) {

    }

    public static int guessNumber(int n)
    {
        int l = 1, r = n;
        while(l < r)
        {
            int mid = l + (r - l) / 2;
            if(guess(mid) <= 0) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    public static int guess(int n)
    {
        return 1;
    }
}
