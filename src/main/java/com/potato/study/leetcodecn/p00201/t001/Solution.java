package com.potato.study.leetcodecn.p00201.t001;

import org.junit.Assert;

/**
 * 201. 数字范围按位与
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

 示例 1: 

 输入: [5,7]
 输出: 4
 示例 2:

 输入: [0,1]
 输出: 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * mn & 一下 找到最大 的那个1
     * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/
     * 基于 一个 推论 两个数字 如果 所有数数字 如果 二进制前缀相同 那么 这个前缀就是 & 之后 的返回值
     * 如何找到
     * 一次 向右 移位 知道 mn 相等 ，记录移动了多少个位置，再移动回来
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>>= 1;
            n >>>= 1;
            shift++;
        }
        while (shift > 0) {
            m <<= 1;
            shift--;
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 5;
        int n = 7;
        int res = solution.rangeBitwiseAnd(m, n);
        System.out.println(res);
        Assert.assertEquals(4, res);


        m = 0;
        n = 1;
        res = solution.rangeBitwiseAnd(m, n);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
