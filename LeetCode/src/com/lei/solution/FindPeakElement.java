package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-02 20:45
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement findPeakElement = new FindPeakElement();
        int peakElement = findPeakElement.findPeakElement(nums);
        System.out.println(peakElement);
    }

    public int findPeakElement(int[] nums) {
//        if (nums.length == 1 || nums[0] > nums[1]) {
////            return 0;
////        }
////        if (nums[nums.length - 1] > nums[nums.length - 2]){
////            return nums.length - 1;
////        }
////        for (int i = 1; i < nums.length - 1; i++) {
////            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
////                return i;
////            }
////        }
////        return -1;
        return binarySearch(nums,0,nums.length);
    }

    public int binarySearch(int[] nums,int left,int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums,left,mid);
        }
        return binarySearch(nums,mid+1,right);
    }
}
