package com.lei.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;

/**
 * @author zhulei
 * @create 2021-04-28 23:48
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 3;
        int[] topKFrequent = topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = 0;
            if (map.get(num) == null) {
                map.put(num,1);
            }else {
                count = map.get(num);
                map.put(num,++count);
            }
        }
        int[] result = new int[k];
        int key = 0;

        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            result[i] = key;
            map.remove(key);
        }

        return result;
    }
}
