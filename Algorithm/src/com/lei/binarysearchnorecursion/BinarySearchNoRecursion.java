package com.lei.binarysearchnorecursion;

/**
 * @author zhulei
 * @create 2021-04-20 9:17
 */
public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr= new int[]{1,4,6,8,11,32,54,64};
        int i = binarySearchNoRecursion(arr, 4);
        System.out.println(i);
    }

    /**
     * 二分查找非递归实现
     * @param arr 带查找的数组
     * @param target 需要找的数
     * @return
     */
    public static int binarySearchNoRecursion(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
