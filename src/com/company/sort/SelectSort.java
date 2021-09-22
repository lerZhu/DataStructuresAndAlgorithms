package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-11 8:36
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,2,4};

//        int min = arr[0];
//        int index = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (min > arr[i]){
//                min = arr[i];
//                index = i;
//            }
//        }
//        arr[index] = arr[0];
//        arr[0] = min;

        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        int min;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min >= arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if(index != i){
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
