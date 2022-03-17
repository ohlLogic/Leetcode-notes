package com.Leetcode;

/**
 * Leetcode911,在线选举
 * 二分
 */
public class LeetcodeDemo911 {
    class TopVotedCandidate {
        int[] times, ans;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            ans = new int[persons.length];
            int[] cnts = new int[times.length];
            int cur = -1; //哨兵
            for(int i = 0; i < persons.length; i++)
            {
                cnts[persons[i]]++;
                //cur记录当前选票最多的
                if(cur == -1 || cnts[persons[i]] >= cnts[cur]) cur = persons[i];
                ans[i] = cur;
            }
        }

        public int q(int t) {
            int l = 0, r = times.length - 1;
            while(l < r)
            {
                int mid = l + r + 1 >> 1;
                if(times[mid] <= t) l = mid;
                else r = mid - 1;
            }
            return ans[l];
        }
    }

}
