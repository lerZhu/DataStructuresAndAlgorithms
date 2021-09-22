package com.lei.InterviewQuestions;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-09-12 10:29
 */
public class ChangeArray {

    public static int[] method1(int[] array1) {
        int max = array1[0];
        int min = array1[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < min) {
                min = array1[i];
                minIndex = i;
            }
        }

        int temp = array1[0];
        array1[0] = array1[maxIndex];
        array1[maxIndex] = temp;

        temp = array1[array1.length - 1];
        array1[array1.length - 1] = array1[minIndex];
        array1[minIndex] = temp;

        return array1;
    }
}
