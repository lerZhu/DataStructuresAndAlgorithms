package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-07-17 23:52
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};

        int repeatNumber = findRepeatNumber(nums);

        System.out.println(repeatNumber);

    }

    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);

        int i = 1;

        for (i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                break;
            }
        }

        return nums[i];
    }
}
