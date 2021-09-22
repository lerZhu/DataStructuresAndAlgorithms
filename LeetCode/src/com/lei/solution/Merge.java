package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-23 22:51
 */
/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 */
public class Merge {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1,3,num2,3);
//        int[] num1 = {0};
//        int[] num2 = {1};
//        merge(num1,0,num2,1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index] = nums1[i];
                index++;
                i++;
            }else {
                temp[index] = nums2[j];
                index++;
                j++;
            }
        }

        while (i < m) {
            temp[index] = nums1[i];
            index++;
            i++;
        }
        while (j < n) {
            temp[index] = nums2[j];
            index++;
            j++;
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }

        System.out.println(Arrays.toString(temp));
    }
}
