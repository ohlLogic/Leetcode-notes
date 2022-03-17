package com.Leetcode;

/**
 * Leetcode773,滑动谜题
 * BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo773 {
    public static void main(String[] args) {
        LeetcodeDemo773 tt = new LeetcodeDemo773();
        int[][] board = new int[][]{{1,2,3},{4,0,5}};
        System.out.println(tt.slidingPuzzle(board));
    }

    //bfs
    class Node{
        String s;
        int x, y;
        Node(String _string, int _x, int _y)
        {
            x = _x; y = _y; s = _string;
        }
    }
    String s, e;
    int x, y;
    public int slidingPuzzle(int[][] board)
    {
        e = "123450";
        s = "";
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                s += board[i][j];
                if(board[i][j] == 0)
                {
                    x = i;
                    y = j;
                }
            }
        }
        return bfs();
    }


    public int bfs()
    {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<Node> d = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();

        d.addLast(new Node(s, x, y));
        map.put(s, 0);

        while(!d.isEmpty())
        {
            Node poll = d.pollFirst();
            int dx = poll.x, dy = poll.y;
            int step = map.get(poll.s);
            if(poll.s.equals(e)) return step;

            for(int[] dir : dirs)
            {
                int nx = dx + dir[0], ny = dy + dir[1];
                if(nx < 0 || nx >= 2 || ny < 0 || ny >= 3) continue;
                String nstr = update(poll.s, dx, dy, nx, ny);
                if(map.containsKey(nstr)) continue;
                d.addLast(new Node(nstr, nx, ny));
                map.put(nstr, step + 1);
            }
        }
        return -1;
    }

    String update(String s, int x, int y, int x1, int y1)
    {
        char[] cs = s.toCharArray();
        char temp = cs[x * 3 + y];
        cs[x * 3 + y] = cs[x1 * 3 + y1];
        cs[x1 * 3 + y1] = temp;
        return String.valueOf(cs);
    }
}
