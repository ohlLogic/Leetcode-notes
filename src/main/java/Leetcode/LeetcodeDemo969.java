package com.Leetcode;

/**
 * Leetcode969,煎饼排序
 * 冒泡排序
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo969 {
    public List<Integer> pancakeSort(int[] arr)
    {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        /**
         * 冒泡排序：每次排序可以确定末尾位置的元素
         */

        int i = n, j = n - 1; //i当前轮排序的元素，j代表i的位置
        while(i > 1)
        {
            //找到i的位置
            int k = 0;
            while(true)
            {
                if(arr[k] == i) break;
                k++;
            }

            //如果i已经在j位置上，直接跳过
            if(k != j)
            {
                //如果i的位置在0处，直接reverse(arr, 0, j)
                if(k != 0)
                {
                    reverse(arr, 0, k);
                    ans.add(k + 1);
                }
                reverse(arr, 0, j);
                ans.add(j + 1);
            }
            i--; j--;
        }
        return ans;
    }

    public void reverse(int[] arr, int l, int r)
    {
        while(l < r)
        {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++; r--;
        }
    }
}
