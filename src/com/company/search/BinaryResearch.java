package com.company.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-04-12 13:43
 */
public class BinaryResearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,5,6,7,8,9};
        System.out.println(binarySearch2(arr,0,arr.length-1,5));
    }

    /**
     * 二分查找
     * @param arr   数组
     * @param left  左边索引
     * @param right 右边索引
     * @param value 要查找的值
     * @return 返回要找的值得下标，没有找到则返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int value) {
        //没找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (value > midValue) {//向右递归
            return binarySearch(arr,mid+1,right,value);
        }else if (value < midValue) {//向左递归
            return binarySearch(arr,left,mid-1,value);
        }else {//找到了
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        //没找到
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (value > midValue) {//向右递归
            return binarySearch2(arr,mid+1,right,value);
        }else if (value < midValue) {//向左递归
            return binarySearch2(arr,left,mid-1,value);
        }else {//找到了

            List<Integer> resultIndex = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                resultIndex.add(temp);
                temp--;
            }
            resultIndex.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                resultIndex.add(temp);
                temp++;
            }
            return resultIndex;
        }
    }
}
