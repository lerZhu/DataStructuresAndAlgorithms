package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-12 10:14
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{234,3534,452,9723,684,3,5,5734546,585,567,512358,74,47};

        System.out.println(maxBit(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int maxBit(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return (max + "").length();
    }

    public static void radixSort(int[] arr) {
        
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中实际存放了几个数据
        int[] count = new int[10];

        for (int i = 0, n = 1; i < maxBit(arr); i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的各位
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][count[digitOfElement]] = arr[j];
                count[digitOfElement]++;
            }
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int j = 0; j < count.length; j++) {
                //如果桶中有数据，放入原数组
                if (count[j] != 0) {
                    //循环该桶
                    for (int k = 0; k < count[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                count[j] = 0;
            }
        }
    }
}
