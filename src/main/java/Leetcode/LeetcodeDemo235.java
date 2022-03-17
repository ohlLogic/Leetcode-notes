package com.Leetcode;

/**
 * Leetcode235,二叉搜索树的最近公共祖先
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo235 {
    public static void main(String[] args) {

    }

    //两次遍历，将从根节点到目标节点的路径存储下来
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for(int i = 0; i < path_p.size() && i < path_q.size(); i++)
        {
            if(path_p.get(i) == path_q.get(i)) ancestor = path_p.get(i);
            else break;
        }
        return ancestor;
    }

    public static List<TreeNode> getPath(TreeNode root, TreeNode tt)
    {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while(node != tt)
        {
            path.add(node);
            if(tt.val < node.val) node = node.left;
            else node = node.right;
        }
        path.add(node);
        return path;
    }

    //一次遍历
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode ancestor = root;
        while(true)
        {
            if(p.val < ancestor.val && q.val < ancestor.val) ancestor = ancestor.left;
            else if(p.val > ancestor.val && q.val > ancestor.val) ancestor = ancestor.right;
            else break;
        }
        return ancestor;
    }
}
