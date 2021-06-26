package com.potato.study.leetcodecn.p01881.t001;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;

/**
 * 1881. 插入后的最大值
 *
 * 给你一个非常大的整数 n 和一个整数数字 x ，大整数 n 用一个字符串表示。n 中每一位数字和数字 x 都处于闭区间 [1, 9] 中，且 n 可能表示一个 负数 。
 *
 * 你打算通过在 n 的十进制表示的任意位置插入 x 来 最大化 n 的 数值 ​​​​​​。但 不能 在负号的左边插入 x 。
 *
 * 例如，如果 n = 73 且 x = 6 ，那么最佳方案是将 6 插入 7 和 3 之间，使 n = 763 。
 * 如果 n = -55 且 x = 2 ，那么最佳方案是将 2 插在第一个 5 之前，使 n = -255 。
 * 返回插入操作后，用字符串表示的 n 的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = "99", x = 9
 * 输出："999"
 * 解释：不管在哪里插入 9 ，结果都是相同的。
 * 示例 2：
 *
 * 输入：n = "-13", x = 2
 * 输出："-123"
 * 解释：向 n 中插入 x 可以得到 -213、-123 或者 -132 ，三者中最大的是 -123 。
 *  
 *
 * 提示：
 *
 * 1 <= n.length <= 105
 * 1 <= x <= 9
 * n​​​ 中每一位的数字都在闭区间 [1, 9] 中。
 * n 代表一个有效的整数。
 * 当 n 表示负数时，将会以字符 '-' 开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-value-after-insertion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 如果 r 是正数 插入位置再第一个大于x位置之后
     * @param n
     * @param x
     * @return
     */
    public String maxValue(String n, int x) {
        if (n.startsWith("-")) {
            int index = 1;
            while (index < n.length() && n.charAt(index) - '0' <= x) {
                index++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(n.substring(0, index));
            builder.append(x);
            if (index < n.length()) {
                builder.append(n.substring(index));
            }
            return builder.toString();

        } else {
            int index = 0;
            while (index < n.length() && n.charAt(index) - '0' >= x) {
                index++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(n.substring(0, index));
            builder.append(x);
            if (index < n.length()) {
                builder.append(n.substring(index));
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String n = "99";
        int x = 9;
        String s = solution.maxValue(n, x);
        System.out.println(s);
        Assert.assertEquals("999", s);

        n = "-13";
        x = 2;
        s = solution.maxValue(n, x);
        System.out.println(s);
        Assert.assertEquals("-123", s);
    }
}
