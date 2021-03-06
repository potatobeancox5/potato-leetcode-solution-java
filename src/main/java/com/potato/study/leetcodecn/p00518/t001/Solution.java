package com.potato.study.leetcodecn.p00518.t001;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 

  

 示例 1:

 输入: amount = 5, coins = [1, 2, 5]
 输出: 4
 解释: 有四种方式可以凑成总金额:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 示例 2:

 输入: amount = 3, coins = [2]
 输出: 0
 解释: 只用面额2的硬币不能凑成总金额3。
 示例 3:

 输入: amount = 10, coins = [10]
 输出: 1
  

 注意:

 你可以假设：

 0 <= amount (总金额) <= 5000
 1 <= coin (硬币面额) <= 5000
 硬币种类不超过 500 种
 结果符合 32 位符号整数

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/coin-change-2
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 硬币面额数组 从大往小排列
     * 类的成员变量计数
     *
     *
     * Dfs 递归求解
     *
     * dfs amount 总金额 （剩余）， 硬币面额数组，目前该使用的硬币index
     * 终止条件
     * 如果当前 amount 已经到 0 直接计数 ++ 返回
     *
     * 如果当前 idex 已经非法了 直接返回
     *
     *
     *
     * fori index - 终点
     * 	如果当前 amount 已经不满足 减了 直接continue 吧
     * 	否则
     * 		dfs amount- 当前前数，硬币面额数组， i（当前用到的面额index）
     *
     *
     *
     * 主函数 直接 返回 成员变量的计数个数
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] coinKinds = new int[amount + 1];
        Arrays.fill(coinKinds, -1);
        // 面额 0 不使用任何硬币即可
        coinKinds[0] = 1;
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                if (coinKinds[i - coins[j]] == -1) {
                    continue;
                }
                if (coinKinds[i] == -1) {
                    coinKinds[i] = 0;
                }
                coinKinds[i] += coinKinds[i - coins[j]];
            }
        }
        return coinKinds[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int change = solution.change(amount, coins);
        System.out.println(change);
        Assert.assertEquals(4, change);

        amount = 3;
        coins = new int[]{2};
        change = solution.change(amount, coins);
        System.out.println(change);
        Assert.assertEquals(0, change);
    }

}
