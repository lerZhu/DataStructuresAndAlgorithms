package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-04-28 23:07
 */

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        //先排序
        Arrays.sort(nums);;
        //找到第k个最大的节点
        return nums[nums.length - k];
    }
}
