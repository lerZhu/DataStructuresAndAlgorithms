package com.lei.swordfingeroffer;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-07-27 23:39
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
