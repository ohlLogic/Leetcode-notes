package com.Leetcode;

public class LeetcodeDemo76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t)
    {
        if(t.length() > s.length()) return "";

        //need数组表示t字符串所有字符所需个数，如果找到则减一，如果need[t.charAt(i)] == 0说明该元素在活动窗口中
        int[] need = new int[128];
        for(int i = 0; i < t.length(); i++)
        {
            need[t.charAt(i)]++;
        }

        //l,r滑动窗口左右顶点，size为滑动窗口大小，cout为需要统计的t字符串的个数，start代表记录最小的滑动窗口起始位置
        int l = 0, r = 0, size = Integer.MAX_VALUE, cout = t.length(), start = 0;
        while(r < s.length())
        {
            char c = s.charAt(r);
            if(need[c] > 0) cout--;
            need[c]--;
            //说明当前滑动窗口中的元素已经包含了t字符串的所有元素
            if(cout == 0)
            {
                //判断当前滑动窗口的左顶点是否是多余元素
                while(need[s.charAt(l)] < 0)
                {
                    //滑动窗口的左顶点右移，缩短滑动窗口大小
                    need[s.charAt(l)]++;
                    l++;
                }
                //如果当前窗口比之前窗口小，更新滑动窗口大小，记录start
                if(r - l + 1 < size)
                {
                    size = r - l + 1;
                    start = l;
                }
                //l此时一定为t字符串必须元素，将l位置的字符统计加1
                need[s.charAt(l)]++;
                l++;
                cout++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
