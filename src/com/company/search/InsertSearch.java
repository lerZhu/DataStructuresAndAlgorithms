package com.company.search;

/**
 * @author zhulei
 * @create 2021-04-12 15:03
 */
public class InsertSearch {
    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int i = insertSearch(arr, 0, arr.length - 1, 4);
        System.out.println(i);

    }

    public static int insertSearch(int[] arr,int left,int right,int value) {
        System.out.println("hello");
        if (left > right || value < arr[0] || value > arr[arr.length-1]) {
            return -1;
        }

        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);

        int midValue = arr[mid];

        if (value > midValue) {
            return insertSearch(arr,mid + 1,right,value);
        }else if (value < midValue) {
            return insertSearch(arr,left,mid - 1,value);
        }else {
            return mid;
        }
    }
}
