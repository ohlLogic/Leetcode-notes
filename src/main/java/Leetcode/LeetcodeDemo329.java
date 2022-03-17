package com.Leetcode;

/**
 * Leetcode329,矩阵中的最长递增矩阵
 */

import java.util.*;

public class LeetcodeDemo329 {
    int m, n;
    int[][] matrix;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] vis;

    class Node{
        int x, y;
        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    //BFS, (TLE)
    public int longestIncreasingPath(int[][] matrix)
    {
        this.matrix = matrix;
        m = matrix.length; n = matrix[0].length;
        vis = new boolean[m][n];

        int max = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                max = Math.max(max, bfs(i, j));
            }
        }
        return max;
    }


    public int bfs(int x, int y)
    {
        for(int i = 0; i < m; i++) Arrays.fill(vis[i], false);

        Deque<Node> d = new ArrayDeque<>();
        Map<Node, Integer> map = new HashMap<>();

        Node node = new Node(x, y);
        d.addLast(node);
        vis[x][y] = true;
        map.put(node, 1);

        int res = 0;
        while(!d.isEmpty())
        {
            Node tt = d.pollFirst();
            int xx = tt.x, yy = tt.y;
            int cnt = map.get(tt);
            res = Math.max(cnt, res);

            for(int[] dir : dirs)
            {
                int nx = xx + dir[0], ny = yy + dir[1];
                //越界直接跳过
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || matrix[xx][yy] >= matrix[nx][ny]) continue;
                Node cur = new Node(nx, ny);
                if(map.containsKey(cur)) continue;
                d.addLast(cur);
                map.put(cur, cnt + 1);
            }
        }
        return res;
    }

    //拓扑排序
    public int longestIncreasingPath1(int[][] matrix)
    {
        //将所有点连起来组成有向无环图
        int m = matrix.length, n = matrix[0].length;

        //记录所有节点的出度
        int[][] outDegree = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //主要该节点旁边的节点比它大，出度加1
                for(int[] dir : dirs)
                {
                    int nx = i + dir[0], ny = j + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[i][j]) outDegree[i][j]++;
                }
            }
        }

        //多源BFS
        Deque<int[]> d = new ArrayDeque<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(outDegree[i][j] == 0) d.addLast(new int[]{i, j});
            }
        }

        int ans = 0;
        while(!d.isEmpty())
        {
            ans++;
            int size = d.size();
            for(int i = 0; i < size; i++)
            {
                int[] poll = d.pollFirst();
                int x = poll[0], y = poll[1];

                for(int[] dir : dirs)
                {
                    int nx = x + dir[0], ny = y + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] < matrix[x][y])
                    {
                        if(--outDegree[nx][ny] == 0)
                        {
                            d.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return ans;
    }

    //记忆化dfs
    public int longestIncreasingPath2(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;

        //记忆化存储
        int[][] memo = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(memo[i][j] == 0) ans = Math.max(ans, dfs(matrix, m, n, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int m, int n, int x, int y, int[][] memo)
    {
        if(memo[x][y] != 0) return memo[x][y];

        int ans = 1;
        for(int[] dir : dirs)
        {
            int nx = dir[0] + x, ny = dir[1] + y;
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y]) ans = Math.max(ans, dfs(matrix, m, n, nx, ny, memo) + 1);
        }

        memo[x][y] = ans;
        return ans;
    }

    //动态规划

    /**
     * dp[i][j]表示从matrix[i,j]出发的最长路径
     * 状态转移：
     * dp[i][j] = max(dp[i',j']) + 1, dp[i',j'] > dp[i][j]
     * 先算较大的数，这样可以避免重复计算
     * @param matrix
     * @return
     */
    public int longestIncreasingPath3(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                list.add(new int[]{matrix[i][j], i, j});
            }
        }

        //按节点进行排序
        list.sort((a, b) -> b[0] - a[0]);

        int ans = 0;
        int[][] dp = new int[m][n];

        //状态初始化
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], 1);

        //状态转移
        for(int[] element : list)
        {
            int val = element[0], x = element[1], y = element[2];
            for(int[] dir : dirs)
            {
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y])
                {
                    dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
                }
            }
            ans = Math.max(ans, dp[x][y]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        LeetcodeDemo329 tt = new LeetcodeDemo329();
        System.out.println(tt.longestIncreasingPath1(matrix));
    }
}
