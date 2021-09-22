package com.lei.solution;

/**
 * @author zhulei
 * @create 2021-05-10 20:43
 */

/**
 *
 */
public class MaxMoney {
    public static void main(String[] args) {
        int[] nums = {100,300000,2,4};

        MaxMoney demo = new MaxMoney();
        int coins = demo.solution(nums);
        int coinsBag = demo.solution2(nums);
        System.out.println(coins);
        System.out.println(coinsBag);
    }

    public int solution(int[] nums) {
        int coins = 100;
        int goodCount = 0;
        int n = nums.length;
        boolean buyFlag = true;

        for (int i = 0; i < n; i++) {
            // 如果是最后一个点，全部卖出
            if (i == n - 1) {
                return coins = coins + goodCount * nums[i];
            }
            // 如果下一节点值小于该节点，该节点全部卖出，下一节点全部买入
            if (nums[i + 1] < nums[i]) {
                // 下一节点需要全部买入
                buyFlag = true;
                //获得的金币数量
                coins = coins + goodCount * nums[i];
                //货物数量置0
                goodCount = 0;

            }else { //如果下一节点的值大于或等于该节点值，判断是否需要买入
                if (buyFlag) {
                    buyFlag = false;
                    goodCount = coins / nums[i];
                    coins = coins % nums[i];
                }
            }
        }

        return coins;
    }

    /**
     * 考虑背包容量
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int maxBag = 100000;
        int coins = 100;
        int goodCount = 0;
        int n = nums.length;
        boolean buyFlag = true;

        for (int i = 0; i < n; i++) {
            // 如果是最后一个点，全部卖出
            if (i == n - 1) {
                return coins = coins + goodCount * nums[i];
            }
            // 如果下一节点值小于该节点，该节点全部卖出，下一节点全部买入
            if (nums[i + 1] < nums[i]) {
                // 下一节点需要全部买入
                buyFlag = true;
                //获得的金币数量
                coins = coins + goodCount * nums[i];
                //货物数量置0
                goodCount = 0;

            }else { //如果下一节点的值大于或等于该节点值，判断是否需要买入
                if (buyFlag) {
                    buyFlag = false;
                    //判断购买的货物数量是否大于背包最大数量
                    goodCount = Math.min(coins / nums[i], maxBag);
                    coins = coins - goodCount * nums[i];
                }
            }
        }

        return coins;
    }
}
