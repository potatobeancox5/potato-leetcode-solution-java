package com.potato.study.leetcodecn.p0069.t001;


import org.junit.Assert;

/**
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sqrtx
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计算平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            // 防止溢出
            long mid = (right - left) / 2 + left;
            long target1 = mid * mid;
            long target2 = (mid + 1) * (mid + 1);
            if (target1 == x) {
                return (int)mid;
            } else if (target1 < x && target2 > x) {
                return (int)mid;
            } else if (target1 < x){
                // 隐含 target2 <= x
                left = (int)mid + 1;
            } else {
                // target1 > x
                right = (int)mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int x = 4;
        int res = solution.mySqrt(x);
        System.out.println(res);
        Assert.assertEquals(2, res);

        x = 8;
        res = solution.mySqrt(x);
        System.out.println(res);
        Assert.assertEquals(2, res);


        x = 2147395599;
        res = solution.mySqrt(x);
        System.out.println(res);
        Assert.assertEquals(46339, res);


    }
}
