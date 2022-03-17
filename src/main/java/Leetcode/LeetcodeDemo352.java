package com.Leetcode;

/**
 * Leetocde352,将数据流变成多个不想交区间
 * 并查集：[l,r]始终记录的是最大值的右边一个，即r+1为区间根节点，不断维护右端区间根节点
 */

import java.util.Arrays;

public class LeetcodeDemo352 {
    int[] nums;
    public static void main(String[] args) {

    }

    public LeetcodeDemo352(){
        nums = new int[10002];
    }

    public void addNum(int val)
    {
        //插入元素，将该元素的根节点设置它的后一个
        if(nums[val] == 0) nums[val] = val + 1;
        find(val);
    }

    public int[][] getIntervals() {
        int n = nums.length;
        int[][] res = new int[n][2];
        int idx = 0;
        for(int i = 0; i < n;)
        {
            if(nums[i] != 0)
            {
                res[idx][0] = i;
                res[idx][1] = find(nums[i]) - 1;
                i = res[idx++][1] + 1;
            }
            else i++;
        }
        return Arrays.copyOfRange(res, 0, idx);
    }

    private int find(int x)
    {
        //如果没插入val == k节点，那么节点的元素设置它自己
        if(nums[x] == 0) return x;
        nums[x] = find(nums[x]);
        return nums[x];
    }
}
