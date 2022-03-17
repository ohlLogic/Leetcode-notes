package com.Leetcode;

/**
 * Leetcode382，链表随机节点
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetcodeDemo382 {
    //用数组+random模拟随机数
    class Solution {
        Random random = new Random(1111);
        List<Integer> list = new ArrayList<>();
        public Solution(ListNode head) {
            while(head != null)
            {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }

    //蓄水池抽样算法
//    class Solution {
//        ListNode head;
//        Random random = new Random(20220116);
//        public Solution(ListNode _head) {
//            head = _head;
//        }
//        public int getRandom() {
//            int ans = 0, idx = 0;
//            ListNode t = head;
//            while (t != null && ++idx >= 0) {
//                if (random.nextInt(idx) == 0) ans = t.val;
//                t = t.next;
//            }
//            return ans;
//        }
//    }
}
