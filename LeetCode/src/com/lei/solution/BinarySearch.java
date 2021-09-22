package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-19 23:02
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        BinarySearch demo = new BinarySearch();
        int i = demo.binarySearch(0, nums.length - 1, nums, 0);
        System.out.println(i);
    }

    public int search(int[] nums, int target) {

        return binarySearch(0,nums.length - 1,nums,target);

    }

    public int binarySearch(int left,int right,int[] nums,int target) {

        // 没找到
        if (left > right) {
            return -1;
        }

        // 取中间值
        int mid = (left + right) / 2;
        int midVal = nums[mid];

        // 如果需要找的值比中间值大，向右递归
        if (target > midVal) {
            return binarySearch(mid + 1,right,nums,target);
            //如果需要找的值比中间值小，向左递归
        }else if (target < midVal) {
            return binarySearch(left,mid - 1,nums,target);
            //需要找的值与中间值相等，找到了
        }else {
            return mid;
        }
    }
}
