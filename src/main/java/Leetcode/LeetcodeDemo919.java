package com.Leetcode;

/**
 * Leetcode919,完全二叉树插入器
 * BFS
 */

import java.util.*;
public class LeetcodeDemo919 {
        class CBTInserter {
        TreeNode root;
        Deque<TreeNode> d;
        public CBTInserter(TreeNode root) {
            this.root = root;
            d = new ArrayDeque<>();

            //BFS
            Deque<TreeNode> temp = new ArrayDeque<>();
            temp.addLast(root);
            while(!temp.isEmpty())
            {
                TreeNode cur = temp.pollFirst();
                if(cur.left != null) temp.addLast(cur.left);
                if(cur.right != null) temp.addLast(cur.right);
                if(cur.left == null || cur.right == null) d.addLast(cur);
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            TreeNode cur = d.peekFirst();
            //插入
            if(cur.left == null) cur.left = node;
            else if(cur.right == null)
            {
                cur.right = node;
                d.pollFirst();
            }
            d.addLast(node);
            return cur.val;
        }

        public TreeNode get_root()
        {
            return root;
        }
    }
}
