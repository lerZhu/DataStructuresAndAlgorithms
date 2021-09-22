package com.lei.solution;

import java.util.concurrent.ForkJoinPool;

/**
 * @author zhulei
 * @create 2021-04-25 21:33
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
//        int[] nums = {0,2};
        int i = maxProduct(nums);
        System.out.println(i);

    }

    public static int maxProduct(int[] nums) {
        //内存爆了
//        int maxValue = nums[0];
//        int n = nums.length;
//        int max[][] = new int[n][n];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                max[i][j] = 1;
//            }
//        }
//        max[0][0] = nums[0];
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                max[i][j] = nums[i] * max[i-1][j];
//                if (max[i][j] > maxValue) {
//                    maxValue = max[i][j];
//                }
//            }
//        }
//        return maxValue;

        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            max = Math.max(imax,max);
        }
        return max;
    }
}
