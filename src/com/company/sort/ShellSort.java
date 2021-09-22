package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-11 10:19
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 53, 2, 345, 23, 45, 3, 5234};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换式希尔排序
     *
     * @param arr 传入的数组
     */
    public static void shellSort(int[] arr) {
        //定义增量
        int gap;
        //
        int temp = 0;
        for (gap = arr.length / 2; gap > 0; gap /= 2) {
            //对分组后的每一组进行遍历
            for (int i = gap; i < arr.length; i++) {
                //分组后的步长是gap，相当于每组的每个数据都间隔gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 移位式希尔排序
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }
}
