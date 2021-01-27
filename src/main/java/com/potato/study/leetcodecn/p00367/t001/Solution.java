package com.potato.study.leetcodecn.p00367.t001;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

 说明：不要使用任何内置的库函数，如  sqrt。

 示例 1：

 输入：16
 输出：True
 示例 2：

 输入：14
 输出：False

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-perfect-square
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 二分法 查找 是不是 平方数
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        long left = 0;
        long right = num / 2;
        while (left <= right) {
            long mid = (left + right) /2;
            long target = mid * mid;
            if (target == num) {
                return true;
            } else if (target < num) {
                left = mid + 1;
            } else {
                // target 大于 num
                right = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 808201;
        boolean res = solution.isPerfectSquare(num);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
