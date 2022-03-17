package com.Leetcode;

/**
 * Leetcode472,连接词
 * 字典树
 */

import java.util.*;

public class LeetcodeDemo472 {
    class Trie {
        Trie[] m_chilren;
        boolean m_is_end;

        public Trie() {
            m_chilren = new Trie[26];
            m_is_end = false;
        }

        Trie trie = new Trie();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> ans = new ArrayList<String>();

            Arrays.sort(words, (x, y) -> x.length() - y.length());

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == 0)
                    continue;

                if (dfs(words[i], 0))
                    ans.add(words[i]);
                else
                    insert_word(words[i], 0);
            }

            return ans;
        }

        public boolean dfs(String s, int pos) {
            if (s.length() == pos)
                return true;

            Trie tmp_trie = trie;

            for (int i = pos; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';

                if (tmp_trie.m_chilren[c] == null)
                    return false;

                if (tmp_trie.m_chilren[c].m_is_end) {
                    if (dfs(s, i + 1))
                        return true;
                }

                tmp_trie = tmp_trie.m_chilren[c];
            }
            return false;
        }

        public void insert_word(String s, int node) {
            Trie tmp_trie = trie;

            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';

                if (tmp_trie.m_chilren[c] == null)
                    tmp_trie.m_chilren[c] = new Trie();

                tmp_trie = tmp_trie.m_chilren[c];

                if (i == s.length() - 1)
                    tmp_trie.m_is_end = true;
            }
        }
    }
}



