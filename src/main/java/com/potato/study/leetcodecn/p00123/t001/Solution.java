package com.potato.study.leetcodecn.p00123.t001;

import org.junit.Assert;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

  

 示例 1:

 输入：prices = [3,3,5,0,0,3,1,4]
 输出：6
 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 示例 2：

 输入：prices = [1,2,3,4,5]
 输出：4
 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 示例 3：

 输入：prices = [7,6,4,3,1]
 输出：0
 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 示例 4：

 输入：prices = [1]
 输出：0
  

 提示：

 1 <= prices.length <= 105
 0 <= prices[i] <= 105

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 不用想就知道是动态规划
     * 标记 4个 收益状态
     * profit0 当前i天之前 没进行过任何交易
     * profit1Start  当前i天之前 做过一次买入的最大收益
     * profit1End  当前i天之前 做过一次买入和卖出的最大收益
     * profit2Start  当前i天之前 做过2次买入的最大收益
     * profit2End  当前i天之前 做过2次买入和卖出的最大收益
     *
     * 开始值都是 0
     *
     * 从0 - len 天开始遍历
     * profit1Start = Max {profit1Start（之前的最大值，0 - 第i天价格）}
     * profit1End = Max {profit1End（之前的最大值，profit1Start + 当天价格）}
     * profit2Start = Max {profit2Start（之前的最大值，profit1End - 第i天价格）}
     * profit2End = Max {profit1Start（之前的最大值，0 - 第i天价格）}
     *
     * 计算最大值
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0){
            return 0;
        }
        int profit1Start = Integer.MIN_VALUE;
        int profit1End = Integer.MIN_VALUE;
        int profit2Start = Integer.MIN_VALUE;
        int profit2End = Integer.MIN_VALUE;
        // 转移
        for (int i = 0; i < prices.length; i++) {
            // 第二次买过了 才能卖
            if (profit2Start != Integer.MIN_VALUE) {
                profit2End = Math.max(profit2End, profit2Start + prices[i]);
            }
            // 第一次卖过了 才能买第二次
            if (profit1End != Integer.MIN_VALUE) {
                profit2Start = Math.max(profit2Start, profit1End - prices[i]);
            }

            // 买过了 才能搞
            if (profit1Start != Integer.MIN_VALUE) {
                profit1End = Math.max(profit1End, prices[i] + profit1Start);
            }
            profit1Start = Math.max(profit1Start, 0 - prices[i]);
        }
        int max = 0;
        max = Math.max(profit1End, max);
        max = Math.max(profit2End, max);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int max = solution.maxProfit(prices);
        System.out.println(max);
        Assert.assertEquals(6, max);


        prices = new int[]{1,2,3,4,5};
        max = solution.maxProfit(prices);
        System.out.println(max);
        Assert.assertEquals(4, max);

        prices = new int[]{7,6,4,3,1};
        max = solution.maxProfit(prices);
        System.out.println(max);
        Assert.assertEquals(0, max);

        prices = new int[]{1};
        max = solution.maxProfit(prices);
        System.out.println(max);
        Assert.assertEquals(0, max);
    }
}
