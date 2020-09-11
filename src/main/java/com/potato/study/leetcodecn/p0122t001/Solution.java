package com.potato.study.leetcodecn.p0122t001;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

  

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 示例 2:

 输入: [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 示例 3:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
  

 提示：

 1 <= prices.length <= 3 * 10 ^ 4
 0 <= prices[i] <= 10 ^ 4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 同一时间只能拥有一支股票
     * 可以进行无限次交易
     * 意味着 从后往前 找 只要 后一个数字大于前一个数字，那么他就必须做这个交易
     * 考虑情况
     * a > b > c 不做
     * a > b < c 做bc
     * a < b < c 做bc ac
     * a > b < c 做bc
     *
     * O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = prices.length - 1; i > 0; i--) {

            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
