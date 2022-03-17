package com.Leetcode;

/**
 * Leetcode1609,奇偶树
 * BFS
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetcodeDemo1609 {
    //层次遍历
    public boolean isEvenOddTree(TreeNode root)
    {
        List<List<Integer>> cnt = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);

        while(!d.isEmpty())
        {
            int len = d.size();
            while(len-- > 0)
            {
                TreeNode node = d.pollFirst();
                cur.add(node.val);
                if(node.left != null) d.addLast(node.left);
                if(node.right != null) d.addLast(node.right);
            }
            cnt.add(new ArrayList<>(cur));
            cur.clear();
        }

        int m = cnt.size();
        for(int i = 0; i < m; i++)
        {
            cur = cnt.get(i);
            if(i % 2 == 1 && !check1(cur)) return false;
            if(i % 2 == 0 && !check2(cur)) return false;
        }
        return true;
    }

    public boolean isEvenOddTree1(TreeNode root)
    {
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        //flag为真代表偶数层
        boolean flag = true;
        while(!d.isEmpty())
        {
            int len = d.size();
            //哨兵
            int prev = flag ? 0 : 0x3f3f3f3f;
            while(len-- > 0)
            {
                TreeNode node = d.pollFirst();
                int cur = node.val;
                if(flag && (cur % 2 == 0 || cur <= prev)) return false;
                if(!flag && (cur % 2 == 1 || cur >= prev)) return false;
                prev = cur;
                if(node.left != null) d.addLast(node.left);
                if(node.right != null) d.addLast(node.right);
            }
            flag = !flag;
        }
        return true;
    }

    //奇数
    public boolean check1(List<Integer> cur)
    {
        for(int i = 0; i < cur.size(); i++)
        {
            if(cur.get(i) % 2 == 1) return false;
        }
        for(int i = 0; i < cur.size() - 1; i++)
        {
            if(cur.get(i) <= cur.get(i + 1)) return false;
        }
        return true;
    }

    //偶数
    public boolean check2(List<Integer> cur)
    {
        for(int i = 0; i < cur.size(); i++)
        {
            if(cur.get(i) % 2 == 0) return false;
        }

        for(int i = 0; i < cur.size() - 1; i++)
        {
            if(cur.get(i) >= cur.get(i + 1)) return false;
        }
        return true;
    }
}
