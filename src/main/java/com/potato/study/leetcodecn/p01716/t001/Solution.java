package com.potato.study.leetcodecn.p01716.t001;

import org.junit.Assert;

/**
 * 1716. 计算力扣银行的钱
 *
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。

 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。

 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。

  

 示例 1：

 输入：n = 4
 输出：10
 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 示例 2：

 输入：n = 10
 输出：37
 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 示例 3：

 输入：n = 20
 输出：96
 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
  

 提示：

 1 <= n <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 第一周 入账 28元
     * 之后 每周 加7元
     * @param n
     * @return
     */
    public int totalMoney(int n) {
        // 计算当前是多少周
        int weekNum = n / 7;
        // 剩余多少天
        int otherDayNum = n % 7;
        // 算已经存了多少个整周的钱
        int total = weekNum * 28 + weekNum * (weekNum - 1) / 2 * 7;
        // 剩下了多少钱
        int start = weekNum + 1;
        for (int i = 0; i < otherDayNum; i++) {
            total += start;
            start++;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int total = solution.totalMoney(n);
        System.out.println(total);
        Assert.assertEquals(10, total);

        n = 10;
        total = solution.totalMoney(n);
        System.out.println(total);
        Assert.assertEquals(37, total);

        n = 20;
        total = solution.totalMoney(n);
        System.out.println(total);
        Assert.assertEquals(96, total);
    }
}
