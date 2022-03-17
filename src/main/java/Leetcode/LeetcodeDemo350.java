package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetcodeDemo350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2,2,1};
        int[] nums2 = {2, 2};
        for (int i : intersect(nums1, nums2)) {
            System.out.println(i);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i]) + 1);
            else map.put(nums1[i], 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                int temp = map.get(i);
                temp--;
                if (temp == 0) map.remove(i);
                else map.put(i, temp);
            }
        }
        int[] tt = new int[list.size()];
        for (int i = 0; i < list.size(); i++) tt[i] = list.get(i);
        Arrays.sort(tt);
        return tt;
    }
}
