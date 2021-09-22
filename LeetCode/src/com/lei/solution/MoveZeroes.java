package com.lei.solution;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-25 23:43
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,8,4,3,2,0,0,3,2,0,5,0,4};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
//        int len = nums.length;
//        int countIndex = 0;
//        int zeroIndex = 0;
//        while (countIndex < nums.length - 1) {
//            while (zeroIndex < len -1 && nums[zeroIndex] != 0) {
//                zeroIndex++;
//            }
//            while (countIndex < len - 1 && nums[countIndex] == 0) {
//                countIndex++;
//            }
//            if (zeroIndex < countIndex) {
//                int temp = nums[zeroIndex];
//                nums[zeroIndex] = nums[countIndex];
//                nums[countIndex] = temp;
//            }else {
//                countIndex++;
//            }
//        }

        int len = nums.length;
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }
}
