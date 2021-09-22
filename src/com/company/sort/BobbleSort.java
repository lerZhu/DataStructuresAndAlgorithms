package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-10 10:17
 */
public class BobbleSort {
    public static void main(String[] args) {

        int arr[] = new int[]{1,6,3,2,4,7,4};
        int arr2[] = new int[]{1,2,3,4,5,6,7};
        bobbleSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    public static void bobbleSort(int arr[]) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0;i < arr.length - 1;i++) {
            for (int j = 0;j < arr.length - i -1;j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }else {
                flag = false;
            }
        }
    }
}

