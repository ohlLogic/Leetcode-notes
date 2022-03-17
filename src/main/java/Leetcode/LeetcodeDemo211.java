package com.Leetcode;

/**
 * Leetcode211,添加与搜索单词
 * Trie字典树
 */
public class LeetcodeDemo211 {
    class Node{
        Node[] tns = new Node[26];
        boolean isWord;
    }

    Node root = new Node();

    public LeetcodeDemo211()
    {

    }

    public void addWord(String word)
    {
        Node p = root;
        for(int i = 0; i < word.length(); i++)
        {
            int u = word.charAt(i) - 'a';
            if(p.tns[u] == null) p.tns[u] = new Node();
            p = p.tns[u];
        }
        p.isWord = true;
    }

    public boolean search(String word)
    {
        return dfs(word, root, 0);
    }

    boolean dfs(String s, Node p, int sInx)
    {
        int n = s.length();
        if(n == sInx) return p.isWord;
        char c = s.charAt(sInx);
        if(c == '.')
        {
            for(int j = 0; j < 26; j++)
            {
            if(p.tns[j] != null && dfs(s, p.tns[j], sInx + 1)) return true;
            }
            return false;
        }
        else{
            int u = c - 'a';
            if(p.tns[u] == null) return false;
            return dfs(s, p.tns[u], sInx + 1);
        }
    }
}
