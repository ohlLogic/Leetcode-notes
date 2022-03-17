package com.Leetcode;

/**
 * Leetcode380,时间插入、删除和获取随机元素
 * 哈希表
 */

import java.util.*;
public class LeetcodeDemo380 {
        class RandomizedSet {
            List<Integer> list;
            Map<Integer, Integer> map;
            Random random;

            /**
             * Initialize your data structure here.
             */
            public RandomizedSet() {
                list = new ArrayList<>();
                map = new HashMap<>();
                random = new Random();
            }

            /**
             * Inserts a value to the set. Returns true if the set did not already contain the specified element.
             */
            public boolean insert(int val) {
                if (map.containsKey(val)) return false;

                map.put(val, list.size());
                list.add(list.size(), val);
                return true;
            }

            /**
             * Removes a value from the set. Returns true if the set contained the specified element.
             */
            public boolean remove(int val) {
                if (!map.containsKey(val)) return false;

                //最后一个元素
                int last = list.get(list.size() - 1);
                //将idx下标的直接用最后一个元素覆盖，删除最后一个元素
                int idx = map.get(val);
                list.set(idx, last);
                map.put(last, idx);
                list.remove(list.size() - 1);
                map.remove(val);
                return true;
            }

            /**
             * Get a random element from the set.
             */
            public int getRandom() {
                return list.get(random.nextInt(list.size()));
            }
        }
}
