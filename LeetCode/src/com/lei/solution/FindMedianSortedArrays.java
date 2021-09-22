package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-07-15 22:48
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {

        FindMedianSortedArrays demo = new FindMedianSortedArrays();
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int[] nums2 = {4,5,67,8,45};
        double medianSortedArrays = demo.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] mergeArr = new int[m+n];

        for (int i = 0; i < m; i++) {
            mergeArr[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            mergeArr[i + m] = nums2[i];
        }

        Arrays.sort(mergeArr);

        double median = 0;
        int p = mergeArr.length;

        if (p % 2 == 0) {
            median = (mergeArr[p/2] + mergeArr[(p/2)-1]) / 2.0;
        }else {
            median = (mergeArr[p/2]);
        }

        System.out.println(Arrays.toString(mergeArr));

        return median;
    }
}
