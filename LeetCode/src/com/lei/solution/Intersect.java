package com.lei.solution;

import java.util.*;

/**
 * @author zhulei
 * @create 2021-04-26 23:29
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] shortNums = (nums1.length <= nums2.length) ? nums1 : nums2;
        int[] longNums = (nums1.length > nums2.length) ? nums1 : nums2;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < shortNums.length; i++) {
            int count;
            if(map.get(shortNums[i]) == null) {
                map.put(shortNums[i],1);
            }else {
                count = map.get(shortNums[i]);
                map.put(shortNums[i],++count);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < longNums.length; i++) {
            int count;
            if (map.get(longNums[i]) != null) {
                count = map.get(longNums[i]);
                if (count != 0) {
                    list.add(longNums[i]);
                    map.put(longNums[i],--count);
                }
            }
        }

        int i = 0;
        int[] arr = new int[list.size()];
        for (Integer integer : list) {
            arr[i++] = integer;
        }

        return arr;

    }
}
