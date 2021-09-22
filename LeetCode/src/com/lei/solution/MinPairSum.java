package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-07-20 23:48
 */
public class MinPairSum {
    public static void main(String[] args) {

    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            target = Math.max(nums[i] + nums[nums.length - 1 - i], target);
        }
        return target;
    }
}
