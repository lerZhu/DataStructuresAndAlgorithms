package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-25 23:38
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
