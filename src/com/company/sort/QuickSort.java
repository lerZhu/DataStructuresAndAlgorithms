package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-11 13:58
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{2345,123,6,23423,63,12312,567};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left,int right) {

        if (left > right) {
            return;
        }

        int base = arr[left];
        int l = left;
        int r = right;
        while (l != r) {
            //从右往左找到一个比基准值小的值
            while (arr[r] >= base && l < r)
                r--;
            //从左往右找到一个比基准值大的值
            while (arr[l] <= base && l < r)
                l++;
            if (l < r) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = base;
        System.out.println(Arrays.toString(arr));
        quickSort(arr,left,l - 1);
        quickSort(arr,l + 1,right);
    }
}
