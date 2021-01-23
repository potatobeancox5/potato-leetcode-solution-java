package com.potato.study.leetcodecn.p00343.t001;


import org.junit.Assert;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

 示例 1:

 输入: 2
 输出: 1
 解释: 2 = 1 + 1, 1 × 1 = 1。
 示例 2:

 输入: 10
 输出: 36
 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 说明: 你可以假设 n 不小于 2 且不大于 58。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/integer-break
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 归纳一下
     * 1 - 1
     * 2 - 1 * 1 = 1
     * 3 - 1 * 2
     * 4 - 2 * 2
     * 5 - 3 * 2
     * 6 - 3 * 3
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] res = new int[]{0, 0, 1, 2, 4, 6, 9};
        if (n < 7) {
            return res[n];
        }
        long totalResult = 1;
        while (n >= 7) {
            totalResult *= 3;
            n -= 3;
        }
        if (n > 1) {
            totalResult *= res[n];
        }
        return (int) totalResult;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.integerBreak(2);
        System.out.println(res);
        Assert.assertEquals(1, res);

        res = solution.integerBreak(10);
        System.out.println(res);
        Assert.assertEquals(36, res);
    }
}
