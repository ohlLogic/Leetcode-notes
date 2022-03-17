package com.Leetcode;

/**
 * Leetcode212,单词搜索2
 */

import java.util.*;

public class LeetcodeDemo212 {
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    int m, n;
    boolean[][] visited;
    String word;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (String word : words) {
            this.word = word;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, 0)) res.add(word);
                }
            }
        }

        return new ArrayList<>(res);
    }

    public boolean dfs(char[][] board, int x, int y, int len) {
        if (len == word.length() - 1) return board[x][y] == word.charAt(len);

        if (board[x][y] == word.charAt(len)) {
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(board, newX, newY, len + 1)) return true;
                }
            }
            //回溯
            visited[x][y] = false;
        }
        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    //Trie字典树
    class TrieNode {
        String s;
        TrieNode[] tns = new TrieNode[26];
    }

    void insert(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        //最后一个节点p.s保存word
        p.s = s;
    }

    char[][] board;
    Set<String> set = new HashSet<>();
    TrieNode root = new TrieNode();
    boolean[][] vis = new boolean[15][15];

    public List<String> findWords1(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (String w : words) insert(w);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int u = board[i][j] - 'a';
                if (root.tns[u] != null) {
                    vis[i][j] = true;
                    dfs1(i, j, root.tns[u]);
                    vis[i][j] = false;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs1(int i, int j, TrieNode node) {
        if (node.s != null) set.add(node.s);
        for (int[] dir : dirs) {
            int dx = i + dir[0], dy = j + dir[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n || vis[dx][dy]) continue;
            int u = board[dx][dy] - 'a';
            if (node.tns[u] != null) {
                vis[dx][dy] = true;
                dfs1(dx, dy, node.tns[u]);
                vis[dx][dy] = false;
            }
        }
    }
}
