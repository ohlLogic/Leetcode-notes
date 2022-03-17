package com.Leetcode;

/**
 * Leetcode832,反转图像
 * 双指针
 */
public class LeetcodeDemo832 {
    public static void main(String[] args) {
        System.out.println(1 ^ 0);
    }

    public static int[][] flipAndInvertImage(int[][] image)
    {
        int m = image.length, n = image[0].length;

        for(int i = 0; i < m; i++)
        {
            int l = 0, r = n - 1;
            while(l < r)
            {
                if(image[i][l] == image[i][r])
                {
                    image[i][l] ^= 1;
                    image[i][r] ^= 1;
                }
                l++;
                r--;
            }
            if(l == r) image[i][l] ^= 1;
        }
        return image;
    }
}
