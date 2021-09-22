package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-11 15:57
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergerSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将待排序的数组进行分离
     * @param arr 待排序的数组
     * @param left 左边有序序列初始索引
     * @param right 右边索引
     * @param temp 临时数组，中转
     */
    public static void mergerSort(int[] arr,int left,int right,int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergerSort(arr,left,mid,temp);
            mergerSort(arr,mid+1,right,temp);

            merger(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr 待排序数组
     * @param left 左边有序序列初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 临时数组，中转
     */
    public static void merger(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;//初始化i，左边序列的初始索引
        int j = mid + 1;//初始化j，右边序列的初始索引
        int t = 0; //指向temp数组的当前索引

        //
        while (i <= mid && j <= right) {
            //如果左边有序序列当前元素小于或等于右边有序序列当前元素
            //就将左边的当前元素拷贝到temp数组
            //后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            }else { //反之，将右边的当前元素拷贝到temp数组
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //左边有序序列还有数据剩余，全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
