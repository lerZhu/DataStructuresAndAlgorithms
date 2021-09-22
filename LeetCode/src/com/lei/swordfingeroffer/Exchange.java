package com.lei.swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulei
 * @create 2021-07-21 22:39
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenList.add(nums[i]);
            }else {
                oddList.add(nums[i]);
            }
        }

        int evenLength = evenList.size();
        int oddLength = oddList.size();

        if (oddLength > 0) {
            for (int i = 0; i < oddLength; i++) {
                nums[i] = oddList.get(i);
            }
        }

        if (evenLength > 0) {
            for (int i = 0; i < evenLength; i++) {
                nums[i + evenLength] = evenList.get(i);
            }
        }
        return nums;
    }
}
