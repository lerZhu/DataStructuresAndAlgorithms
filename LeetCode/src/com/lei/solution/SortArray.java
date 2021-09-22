package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-05-03 23:42
 */
public class SortArray {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        SortArray sortArray = new SortArray();
        int[] ints = sortArray.sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr,left,r);
        }
        if (right > l) {
            quickSort(arr,l,right);
        }
    }
}
