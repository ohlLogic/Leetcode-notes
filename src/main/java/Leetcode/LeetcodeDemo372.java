package com.Leetcode;

/**
 * Leetcode372,超级次方
 * 快速幂
 */
public class LeetcodeDemo372 {
    int Mod = 1337;
    public int superPow(int a, int[] b)
    {
        return dfs(a, b, b.length - 1);
    }

    public int dfs(int a, int[] b, int u)
    {
        if(u == -1) return 1;
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % Mod;
    }

    public int qpow(int a, int b)
    {
        int ans = 1;
        a %= Mod;
        while(b != 0)
        {
            if((b & 1) != 0) ans = ans * a % Mod;
            a = a * a % Mod;
            b >>= 1;
        }
        return ans;
    }
}
