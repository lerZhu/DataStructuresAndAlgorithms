package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-11 9:25
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{34,22,53,4,124,25,2342,532};

        insertSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //要进行插入排序的数，暂存
            int insertValue = arr[i];
            //要进行插入的数的前一个坐标，开始比较的坐标
            int insertIndex = i - 1;
//            for (int j = i; j > 0; j--) {
//                if (insertValue < arr[insertIndex])  {
//                    arr[insertIndex + 1] = arr[insertIndex];
//                    insertIndex--;
//                }
//            }
            //1、进行比较的坐标始终》=0，为了防止角标越界
            //2、进行排序的数小于扫描的数
            //被扫描到的数后移一位
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //进行后移
                arr[insertIndex + 1] = arr[insertIndex];
                //继续扫描前一个数
                insertIndex--;
            }
            //找到需要插入的位置，把要排序的数进行插入
            //应为insertIndex在之前的循环中先--再跳出循环，所以需要+1再进行插入
            arr[insertIndex + 1] = insertValue;
        }
    }
}
