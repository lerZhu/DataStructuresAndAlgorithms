package com.lei.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhulei
 * @create 2021-04-22 23:54
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i],1);
            }else {
                map.put(nums[i],2);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                target = entry.getKey();
                break;
            }
        }
        return target;
    }
}
