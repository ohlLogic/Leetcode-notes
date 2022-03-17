package com.Leetcode;

import java.util.Arrays;

public class LeetcodeDemo881 {
    public static void main(String[] args) {
        int[] nums = {3,5,3,4};
        System.out.println(numTescueBoats(nums, 5));
    }

    //双指针
    public static int numTescueBoats(int[] people, int limit)
    {
        int n = people.length;
        Arrays.sort(people);

        int l = 0, r = n - 1;
        int res = 0;
        //统计体重等于limit的人数，单独坐一艘船
        while(r >= 0 && people[r] == limit) {
            res++;
            r--;
        }


        while(l < r)
        {
            if(people[l] + people[r] <= limit)
            {
                l++;
                r--;
                res++;
            }
            else if(people[l] + people[r] > limit) {
                r--;
                res++;
            }

        }
        //单独剩下一个人
        if(l == r) res++;
        return res;
    }

    public static int numRescueBoats1(int[] people, int limit)
    {
        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1;
        int res = 0;
        while(l <= r)
        {
            if(people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }
        return res++;
    }
}
