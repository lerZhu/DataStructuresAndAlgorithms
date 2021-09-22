package com.lei.solution;

import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-05-04 9:36
 */

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-1000};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1] + nums[i],nums[i]);
        }
        Arrays.sort(res);
        return res[nums.length - 1];
    }
}
