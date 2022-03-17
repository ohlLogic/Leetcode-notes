package com.Leetcode;

/**
 * Leetcode117,填充每个节点的下一个右侧节点2
 * 层次遍历
 */

public class LeetcodeDemo117 {
    public static void main(String[] args) {

    }

//    public static Node connect(Node root)
//    {
//        if(root == null) return root;
//        List<List<Node>> list = new ArrayList<>();
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while(!queue.isEmpty())
//        {
//            List<Node> ll = new ArrayList<>();
//            int len = queue.size();
//            while(len > 0)
//            {
//                Node temp = queue.poll();
//                ll.add(temp);
//                if(temp.left != null) queue.add(temp.left);
//                if(temp.right != null) queue.add(temp.right);
//                len--;
//            }
//            list.add(ll);
//        }
//
//        for (List<Node> tt : list) {
//            for(int i = 0; i < tt.size() - 1; i++)
//            {
//                tt.get(i).next = tt.get(i + 1);
//            }
//        }
//        return root;
//    }
//}
}