package com.potato.study.leetcodecn.p00322.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 你可以认为每种硬币的数量是无限的。

  

 示例 1：

 输入：coins = [1, 2, 5], amount = 11
 输出：3
 解释：11 = 5 + 5 + 1
 示例 2：

 输入：coins = [2], amount = 3
 输出：-1
 示例 3：

 输入：coins = [1], amount = 0
 输出：0
 示例 4：

 输入：coins = [1], amount = 1
 输出：1
 示例 5：

 输入：coins = [1], amount = 2
 输出：2
  

 提示：

 1 <= coins.length <= 12
 1 <= coins[i] <= 231 - 1
 0 <= amount <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/coin-change
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 动态规划
     * mincoin i 表示 凑成 i的最小硬币数
     *  初始化mincoin k = 1 mincoin 0=0
     *  mincoin i等于 min mincoin j +1
     *  其中 i等于 j+coin 数量
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0) {
            return -1;
        }
        int[] minCoin = new int[amount + 1];
        // 初始化成-1
        Arrays.fill(minCoin, -1);
        minCoin[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] >= minCoin.length) {
                continue;
            }
            minCoin[coins[i]] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                if (minCoin[i - coins[j]] == -1) {
                    continue;
                }
                min = Math.min(min, minCoin[i - coins[j]] + 1);
            }
            if (min != Integer.MAX_VALUE) {
                minCoin[i] = min;
            }
        }
        return minCoin[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int num = solution.coinChange(coins, amount);
        System.out.println(num);
        Assert.assertEquals(3, num);

        coins = new int[]{2};
        amount = 3;
        num = solution.coinChange(coins, amount);
        System.out.println(num);
        Assert.assertEquals(-1, num);

        coins = new int[]{1};
        amount = 0;
        num = solution.coinChange(coins, amount);
        System.out.println(num);
        Assert.assertEquals(0, num);

        coins = new int[]{1};
        amount = 1;
        num = solution.coinChange(coins, amount);
        System.out.println(num);
        Assert.assertEquals(1, num);

        coins = new int[]{1};
        amount = 2;
        num = solution.coinChange(coins, amount);
        System.out.println(num);
        Assert.assertEquals(2, num);
    }
}
