package com.company.sort;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-12 9:13
 */
public class MySort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        quickSort(arr,0,arr.length-1);
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);

            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 归并
     * @param arr   待排序数组
     * @param left  左下标
     * @param mid   中间值
     * @param right 右下标
     * @param temp  临时数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;//左边序列初始下标
        int j = mid + 1;//右边序列初始下标
        int t = 0;//temp数组当前下标

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //左边有序序列还有数据剩余，全部加入temp数组
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        //右边有序序列还有数据剩余，全部加入temp数组
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //回传给arr
        t=0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    /**
     * 快速排序
     * @param arr 待排序数组
     * @param left  排序开始的左下标
     * @param right 右下标
     */
    public static void quickSort(int[] arr,int left,int right) {
        if (left > right) {
            return;
        }

        int base = arr[left];
        int l = left;
        int r = right;
        while (l != r) {
            while (l < r && arr[r] >= base)
                r--;
            while (l < r && arr[l] <= base)
                l++;
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        arr[left] = arr[l];//基准数归位
        arr[l] = base;
        quickSort(arr,left,l-1);
        quickSort(arr,l + 1,right);
    }

    /**
     * 希尔排序
     * @param arr 待排序数组
     */
    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                int insertValue = arr[insertIndex];
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    /**
     * 选择排序
     * @param arr 待排序数组
     */
    public static void selectSort(int[] arr) {
        int min;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

    /**
     * 冒泡排序
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

