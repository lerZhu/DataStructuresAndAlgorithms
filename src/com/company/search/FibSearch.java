package com.company.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-12 15:21
 */
public class FibSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {

        int[] fib = fib();
        System.out.println(Arrays.toString(fib));

    }

    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fib();

        while (high > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr,f[k]);
        //使用arr最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            }else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

    //的带==得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i -2];
        }
        return f;
    }
}
