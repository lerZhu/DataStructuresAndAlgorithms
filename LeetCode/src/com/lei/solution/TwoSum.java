package com.lei.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhulei
 * @create 2021-05-02 22:58
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, 17);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    res[0] = i;
//                    res[1] = j;
//                }
//            }
//        }
//        return res;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsValue(target - nums[i])) {
                return new int[]{target - nums[i],nums[i]};
            }
            hashMap.put(i,nums[i]);
        }
        return new int[0];
    }
}
