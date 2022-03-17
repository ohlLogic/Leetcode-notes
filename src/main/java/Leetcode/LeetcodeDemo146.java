package com.Leetcode;

/**
 * Leetcode146,LRU缓存机制
 * 哈希表
 */

import java.util.*;
public class LeetcodeDemo146 {
    class LRUCache {
        class Node {
            int key, val;
            Node l, r;

            Node(int k, int v) {
                key = k;
                val = v;
            }
        }

        int n; //容量
        Node head, tail; //哨兵
        Map<Integer, Node> map; //哈希表

        public LRUCache(int capacity) {
            n = capacity;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.r = tail;
            tail.l = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                refresh(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = null;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.val = value;
            } else {
                if (map.size() == n) {
                    Node del = tail.l;
                    map.remove(del.key);
                    delete(del);
                }
                node = new Node(key, value);
                map.put(key, node);
            }
            refresh(node);
        }

        //将当前节点从双向链表中删除，再添加到双向链表头部
        void refresh(Node node) {
            delete(node);
            node.r = head.r;
            node.l = head;
            head.r.l = node;
            head.r = node;
        }

        //将当前节点从双向链表中删除
        void delete(Node node) {
            if (node.l != null) {
                Node left = node.l;
                left.r = node.r;
                node.r.l = left;
            }
        }
    }
}

