package com.Leetcode;

/**
 * Leetcode284,窥探迭代器
 *
 */

import java.util.Iterator;

public class LeetcodeDemo284 {
    public static void main(String[] args) {


    }
}

class PeekingIterator<E> implements Iterator<E> {
    Iterator<E> iter;
    E next;
    public PeekingIterator(Iterator<E> iterator) {
        iter = iterator;
        next = iter.next();
    }

    public E peek() {
        return next;
    }

    @Override
    public E next() {
        E ans = next;
        next = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
