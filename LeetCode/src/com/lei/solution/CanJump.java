package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-06 16:10
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
                if (f[j] && j + nums[j] >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }
}
