package com.lei.solution;

import java.util.*;

/**
 * @author zhulei
 * @create 2021-05-12 13:46
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {

        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i],1);
            }else {
                int count = map.get(nums[i]);
                map.put(nums[i],++count);   
            }
        }

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1) {
                list.add(entry.getKey());
            }
        }

        return list;

    }
}
