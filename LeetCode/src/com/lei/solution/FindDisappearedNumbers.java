package com.lei.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-05-09 23:31
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearedNumbers demo = new FindDisappearedNumbers();
        List<Integer> disappearedNumbers = demo.findDisappearedNumbers(nums);
        for (Integer disappearedNumber : disappearedNumbers) {
            System.out.println(disappearedNumber);
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            //判断数组当前值是否是对应的值，是的话i后移
            //当前数字本就出现在理应的位置上，跳过，不用换。
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            //idealIdx 表示 nums[i] 应该在的位置
            int idealIdx = nums[i] - 1;
            //判断是否需要交换
            //当前数字理应出现的位置上，已经存在当前数字，跳过，不用换。
            if (nums[i] == nums[idealIdx]) {
                i++;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = tmp;
        }
        //再次遍历，如果当前位置没对应正确的数，加入 res。
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;
    }
}
