package com.Leetcode;

/**
 * Leetcode720,词典中最长的单词
 * 字典树Trie
 */
public class LeetcodeDemo720 {
    class Node{
        boolean end;
        String word;
        Node[] next = new Node[26];
    }

    Node root = new Node();
    String ans = "";
    int maxDepth = 0;

    public void insert(String s)
    {
        Node p = root;
        for(int i = 0; i < s.length(); i++)
        {
            int u = s.charAt(i) - 'a';
            if(p.next[u] == null) p.next[u] = new Node();
            p = p.next[u];
        }
        p.end = true;
        p.word = s;
    }

    public String longestWord(String[] words)
    {
        for(String word : words) insert(word);

        dfs(root, 0);
        return ans;
    }

    public void dfs(Node root, int depth)
    {
        if(depth > 0 && !root.end) return;
        if(depth > maxDepth)
        {
            ans = root.word;
            maxDepth = depth;
        }

        for(int i = 0; i < 26; i++)
        {
            if(root.next[i] != null) dfs(root.next[i], depth + 1);
        }
    }
}
