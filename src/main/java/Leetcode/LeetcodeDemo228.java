package com.Leetcode;

/**
 * Leetcode228,汇总区间
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo228 {
    public List<String> summaryRanges(int[] nums)
    {
        List<String> ans = new ArrayList<>();
        List<int[]> cnt = new ArrayList<>();

        if(nums.length == 0) return ans;
        for(int i = 0; i < nums.length; i++)
        {
            if(cnt.isEmpty() || nums[i] > cnt.get(cnt.size() - 1)[1] + 1) cnt.add(new int[]{nums[i], nums[i]});
            else{
                cnt.get(cnt.size() - 1)[1] = nums[i];
            }
        }

        for(int i = 0; i < cnt.size(); i++)
        {
            int[] cur = cnt.get(i);
            if(cur[0] == cur[1]) ans.add("" + cur[0]);
            else ans.add(cur[0] + "->" + cur[1]);
        }
        return ans;
    }


    public List<String> summaryRanges1(int[] nums)
    {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return ans;

        int left = 0, right = 0;
        while(right < n)
        {
            while(right < n - 1 && nums[right] + 1 == nums[right + 1]) right++;
            if(nums[left] != nums[right]) ans.add(nums[left] + "->" + nums[right]);
            else ans.add(nums[left] + "");

            right++;
            left = right;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetcodeDemo228 tt =  new LeetcodeDemo228();
        int[] nums = {0,1,2,4,5,7};
        System.out.println(tt.summaryRanges1(nums));
    }
}
