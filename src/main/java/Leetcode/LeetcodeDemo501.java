package com.Leetcode;

/**
 * Leetcode501,二叉搜索树中众数
 * DFS + 中序遍历
 */

import java.util.*;

public class LeetcodeDemo501 {
    int cnt, maxcnt;
    TreeNode pre;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root)
    {
        dfs(root);
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    public void dfs(TreeNode root)
    {
        if(root == null) return;

        dfs(root.left);

        //判断pre与root的值是否相等
        if(pre == null) cnt = 1;
        else if(pre.val == root.val) cnt++;
        else cnt = 1;

        //更新
        pre = root;

        if(cnt == maxcnt) res.add(root.val);

        if(cnt > maxcnt)
        {
            maxcnt = cnt;
            res.clear();
            res.add(root.val);
        }

        dfs(root.right);
    }

}
