package com.lei.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-04-23 22:05
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }


    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        return nums[(nums.length / 2)];
    }
}
