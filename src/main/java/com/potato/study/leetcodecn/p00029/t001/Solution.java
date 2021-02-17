package com.potato.study.leetcodecn.p00029.t001;


import org.junit.Assert;

/**
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

 返回被除数 dividend 除以除数 divisor 得到的商。

 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

  

 示例 1:

 输入: dividend = 10, divisor = 3
 输出: 3
 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 示例 2:

 输入: dividend = 7, divisor = -3
 输出: -2
 解释: 7/-3 = truncate(-2.33333..) = -2
  

 提示：

 被除数和除数均为 32 位有符号整数。
 除数不为 0。
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/divide-two-integers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    public int divide(int dividend, int divisor) {
        return divide((long)dividend, (long)divisor);
    }
    /**
     *
     * @param dividend  被除数
     * @param divisor   除数
     * @return
     */
    private int divide(long dividend, long divisor) {
        if (0 == dividend) {
            return 0;
        }
        if (divisor == 1) {
            return (int)dividend;
        }
        if (divisor == -1) {
            dividend = 0 - dividend;
            if (dividend < Integer.MIN_VALUE || dividend > Integer.MAX_VALUE) {
                dividend = Integer.MAX_VALUE;
            }
            return (int) dividend;
        }
        // 计算结果是够是 负数
        boolean isNegative = false;
        if (dividend > 0 && divisor < 0) {
            isNegative = true;
            divisor = divisor * -1;
        }
        if (dividend < 0 && divisor > 0) {
            isNegative = true;
            dividend = dividend * -1;
        }
        if (dividend < 0 && divisor < 0) {
            divisor = divisor * -1;
            dividend = dividend * -1;
        }
        // 至此 结果都是正数 ，如果 除数大于被除数 直接返回 0 剪枝
        if (dividend < divisor) {
            return 0;
        }
        // 一个 推论 结果一定在 【0，dividend】 之间
        long left = 1;
        long right = dividend;
        long res = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = ((left + right) >>> 1);
            long temp = multiply(divisor, mid);
            if (dividend == temp) {
                res = mid;
                break;
            } else if (temp < dividend) {
                // 判断 temp 是不是再大一点就 超过 被除数了
                if (temp + divisor > dividend) {
                    res = mid;
                    break;
                }
                left = mid + 1;
            } else {
                // dividend < temp
                right = mid - 1;
            }
        }
        if (isNegative) {
            res *= -1;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }

    /**
     * 通过倍增实现乘法
     * @param first
     * @param second
     * @return
     */
    private long multiply (long first, long second) {
        long res = 0;
        while (second > 0) {
            // second 最低位置 是多少 是1的话 结果需要加上当前的 a
            if ((second & 1) == 1) {
                res += first;
            }
            // 移动位置 second 去掉最后一个位。 first转换成代表当前位置的数
            first = first << 1;
            second = second >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int dividend = 10;
        int divisor = 3;
        int index = solution.divide(dividend, divisor);
        System.out.println(index);
        Assert.assertEquals(3, index);

        dividend = 7;
        divisor = -3;
        index = solution.divide(dividend, divisor);
        System.out.println(index);
        Assert.assertEquals(-2, index);

        dividend = -2147483648;
        divisor = -1;
        index = solution.divide(dividend, divisor);
        System.out.println(index);
        Assert.assertEquals(2147483647, index);


        dividend = -2147483648;
        divisor = 1;
        index = solution.divide(dividend, divisor);
        System.out.println(index);
        Assert.assertEquals(-2147483648, index);


        dividend = 2147483647;
        divisor = 2;
        index = solution.divide(dividend, divisor);
        System.out.println(index);
        Assert.assertEquals(1073741823, index);


    }
}
