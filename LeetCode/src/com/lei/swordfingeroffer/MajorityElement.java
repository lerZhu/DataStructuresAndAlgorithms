package com.lei.swordfingeroffer;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-07-27 23:35
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
