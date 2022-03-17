package com.Leetcode;

import java.util.*;

import static com.Leetcode.LeetcodeDemo98.MidOrder;

public class LeetcodeDemo653 {
    public static void main(String[] args) {

    }

    //中序遍历，将访问结果放置在一个数组中，用哈希表了来判断数组中是否有两个元素相加等于k
    public static boolean findTarget(TreeNode root, int k)
    {
        List<Integer> list = new ArrayList<>();
        MidOrder(root, list);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size();  i++)
        {
            if(map.containsKey(k - list.get(i))) return true;
            map.put(list.get(i), i);
        }
        return false;
    }

    //递归+HashSet
    public static boolean findTarget1(TreeNode root, int k)
    {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    public static boolean find(TreeNode root, int k, Set<Integer> set)
    {
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }


}
