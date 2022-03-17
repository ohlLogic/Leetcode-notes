package com.Leetcode;

/**
 * Leetcode706,设计哈希映射
 */

public class LeetcodeDemo706 {
//    class MyHashMap{
//        int INF = Integer.MAX_VALUE;
//        int N = 1000009;
//        int[] map = new int[N];
//        public MyHashMap(){
//            Arrays.fill(map, INF);
//        }
//
//        public void put(int key, int value){
//            map[key] = value;
//        }
//
//        public int get(int key){
//            return map[key] == INF ? -1 : map[key];
//        }
//
//        public void remove(int key)
//        {
//            map[key] = INF;
//        }
//    }

    //链表
    class MyHashMap{
        static class Node{
            int key, value;
            Node next;
            Node(int k, int v)
            {
                this.key = k;
                this.value = v;
            }
        }

        Node[] nodes = new Node[10009];

        public void put(int key, int value)
        {
            //根据key获取哈希桶的位置
            int idx = getIndex(key);
            Node loc = nodes[idx], temp = loc;
            if(loc != null)
            {
                Node prev = null;
                while(temp != null)
                {
                    if(temp.key == key)
                    {
                        temp.value = value;
                        return;
                    }
                    prev = temp;
                    temp = temp.next;
                }
                temp = prev;
            }
            Node node = new Node(key, value);
            if(temp != null) temp.next = node;
            else nodes[idx] = node;
        }
        public void remove(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];
            if (loc != null) {
                Node prev = null;
                while (loc != null) {
                    if (loc.key == key) {
                        if (prev != null) {
                            prev.next = loc.next;
                        } else {
                            nodes[idx] = loc.next;
                        }
                        return;
                    }
                    prev = loc;
                    loc = loc.next;
                }
            }
        }

        public int get(int key) {
            int idx = getIndex(key);
            Node loc = nodes[idx];
            if (loc != null) {
                while (loc != null) {
                    if (loc.key == key) {
                        return loc.value;
                    }
                    loc = loc.next;
                }
            }
            return -1;
        }

        int getIndex(int key) {
            // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
            // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
            // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
            int hash = Integer.hashCode(key);
            hash ^= (hash >>> 16);
            return hash % nodes.length;
        }

    }
}
