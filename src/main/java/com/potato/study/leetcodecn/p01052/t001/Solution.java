package com.potato.study.leetcodecn.p01052.t001;

import org.junit.Assert;

/**
 * 1052. 爱生气的书店老板
 *
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
  

 示例：

 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 输出：16
 解释：
 书店老板在最后 3 分钟保持冷静。
 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
  

 提示：

 1 <= X <= customers.length == grumpy.length <= 20000
 0 <= customers[i] <= 1000
 0 <= grumpy[i] <= 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 每天的客户是一定的 那么通过滑动时间窗口能求出 哪个时间窗口 最大 那么就是那个时间窗口生气
     * @param customers
     * @param grumpy
     * @param x
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        // 遍历 customers grumpy 求不控制 的 客人数 求滑动窗口 x 控制住的客人数
        int notAngryCustomerNum = 0;
        int maxAngryCustomerNum = 0;
        int angryCustomerNum = 0;
        for (int i = 0; i < customers.length; i++) {
            // 总数
            if (grumpy[i] == 0) {
                notAngryCustomerNum += customers[i];
            }

            if (i == 0) {
                // 生成 窗口内
                for (int j = 0; j < x; j++) {
                    if (grumpy[j] == 1) {
                        angryCustomerNum += customers[j];
                    }
                }
            } else {
                // 加上 i+ x
                if (i + x - 1 <  customers.length && grumpy[i + x - 1] == 1) {
                    angryCustomerNum += customers[i + x - 1];
                }
                // 减去 i- 1
                if (grumpy[i-1] == 1) {
                    angryCustomerNum -= customers[i-1];
                }
            }
            maxAngryCustomerNum = Math.max(maxAngryCustomerNum, angryCustomerNum);
        }
        return notAngryCustomerNum + maxAngryCustomerNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] customers = {1,1,7,5};
        int[] grumpy =    {0,1,0,1};
        int x = 3;
        int num = solution.maxSatisfied(customers, grumpy, x);
        System.out.println(num);
        Assert.assertEquals(14, num);
    }
}
