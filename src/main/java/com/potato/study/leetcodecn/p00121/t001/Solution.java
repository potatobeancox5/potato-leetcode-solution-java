package com.potato.study.leetcodecn.p00121.t001;

import org.junit.Assert;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

 注意：你不能在买入股票前卖出股票。

  

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 通过次数293,473提交次数533,929

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从前往后 找到当前位置最小值
     * 从后往前 找到当前位置之后最大值
     * 遍历上面两个数组 求差 记录max
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                min[i] = prices[i];
                continue;
            }
            min[i] = Math.min(prices[i], min[i-1]);
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            if (i == prices.length - 1) {
                max[i] = prices[i];
                continue;
            }
            max[i] = Math.max(prices[i], max[i+1]);
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, max[i] - min[i]);
        }

        if (maxProfit < 0) {
            return 0;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{7,1,5,3,6,4};
        int maxProfit = solution.maxProfit(arr);
        System.out.println(maxProfit);
        Assert.assertEquals(5, maxProfit);
    }
}
