package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-04-27 21:49
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {20,100,10,12,5,13};
        boolean b = increasingTriplet(nums);
        System.out.println(b);
    }

    public static boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int three : nums) {
            if (three > two) {
                return true;
            }else if (three <= one) {
                one = three;
            }else {
                two = three;
            }
        }
        return false;
    }
}
