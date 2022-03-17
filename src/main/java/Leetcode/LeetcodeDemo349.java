package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetcodeDemo349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        for (int i : intersect(nums1, nums2)) {
            System.out.println(i);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) map.put(nums1[i], i);


        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                list.add(nums2[j]);
                map.remove(nums2[j]);
            }
        }
        int n = list.size();
        int[] tt = new int[n];
        for (int i = 0; i < n; i++) tt[i] = list.get(i);
        return tt;
    }
}
