package com.Leetcode;

/**
 *Leetcode165,比较版本号
 * 多进制加法模板，分别扫描version1和version2的String数组，判断当前位是否相等
 */
public class LeetcodeDemo165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1.0.0"));

    }

    public static int compareVersion(String version1, String version2)
    {
        int i = 0, j = 0;
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        while(i < str1.length || j < str2.length)
        {
            int a = i < str1.length ? Integer.parseInt(str1[i]) : 0;
            int b = j < str2.length ? Integer.parseInt(str2[j]) : 0;
            if(a > b) return 1;
            else if(a < b) return -1;
            else{
                i++;
                j++;
            }
        }

        return 0;
    }
}
