package com.lei.swordfingeroffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhulei
 * @create 2021-07-28 22:09
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            }else if (s > target) {
                j--;
            }else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
