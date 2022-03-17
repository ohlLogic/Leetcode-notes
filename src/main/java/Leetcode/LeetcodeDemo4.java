package com.Leetcode;

/**
 * leetcode4，寻找两个正序数组的中位数
 * 方法一：将两个数组合并一个数组temp，采用快速排序一个递增数组，判断temp的个数
 * 如果temp数组的个数为偶数，返回中间两个值的平均值；如果temp数组的个数为奇数，返回temp数组中间的值。
 *
 * 方法二：
 */
public class LeetcodeDemo4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(fidnMedianSortedArrays2(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //处理特殊输入
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0)
                return ((double) nums2[nums2.length / 2] + (double) nums2[nums2.length / 2 - 1]) / 2;
            else return (double) nums2[nums2.length / 2];
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 0)
                return ((double) nums1[nums1.length / 2] + (double) nums1[nums1.length / 2 - 1]) / 2;
            else return (double) nums1[nums1.length / 2];
        }

        double[] temp = new double[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (i < nums1.length) temp[i] = nums1[i];
            else temp[i] = nums2[i - nums1.length];
        }

        //快速排序
        quick_sort(temp, 0, temp.length - 1);

        if (temp.length % 2 == 0) return (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
        else return temp[temp.length / 2];
    }

    //快速排序
    public static void quick_sort(double[] temp, int l, int r) {
        if (l >= r) return;

        double x = temp[l + r >> 1];
        int i = l - 1, j = r + 1;

        while (i < j) {
            do i++; while (temp[i] < x);
            do j--; while (temp[j] > x);
            if (i < j) {
                double tmp = temp[i];
                temp[i] = temp[j];
                temp[j] = tmp;
            }

        }
        quick_sort(temp, l, j);
        quick_sort(temp, j + 1, r);
    }

    //二分法
    public static double fidnMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            return getKthElement(nums1, nums2, length / 2 + 1);
        } else {
            return getKthElement(nums1, nums2, length / 2) / 2.0 + getKthElement(nums1, nums2, length / 2 + 1) / 2.0;
        }
    }

    public static double getKthElement(int[] nums1, int[] nums2, int k) {
        //k代表实际要找的位置
        int length1 = nums1.length, length2 = nums1.length;
        int index1 = 0, index2 = 0;

        while (true) {
            //边界情况，index代表每次二分开始数组起始位置
            if (index1 == length1) return nums2[index2 + k - 1];
            if (index2 == length2) return nums1[index1 + k - 1];
            if(k == 1) return Math.min(nums1[index1], nums2[index2]);

            //正常情况
            int half = k / 2;
            //newIndex代表数组每组二分比较位置
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            if(nums1[newIndex1] <= nums2[newIndex2])
            {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


}
