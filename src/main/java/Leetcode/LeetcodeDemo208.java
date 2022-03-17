package com.Leetcode;

/**
 * Leetcode208,实现Trie(前缀树)
 */

import java.util.Arrays;

public class LeetcodeDemo208 {
    static int N = 100009;
    static int[][] trie;
    static int[] count;
    static int index = 0;
    public static void main(String[] args) {

    }

    public LeetcodeDemo208()
    {
        for(int row = index; row >= 0; row--) Arrays.fill(trie[row], 0);
        Arrays.fill(count, 0);
        index = 0;
    }

    public void insert(String s)
    {
        int p = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int u = s.charAt(i) - 'a';
            if(trie[p][u] == 0) trie[p][u] = ++index;
            p = trie[p][u];
        }
        count[p]++;
    }

    public boolean search(String s)
    {
        int p = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int u = s.charAt(i) - 'a';
            if(trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return count[p] != 0;
    }

    public boolean startWith(String s)
    {
        int p = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int u = s.charAt(i) - 'a';
            if(trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return true;
    }
}

class Trie {
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
}
