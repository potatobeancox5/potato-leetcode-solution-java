package com.potato.study.leetcodecn.p01780.t001;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.google.common.collect.Lists;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 *
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 *
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 *
 * 输入：n = 21
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= n <= 107
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 如果可以被3 整除 那么就 / 3 否则 -1 判定 是否可以被整除
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        while (n != 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n = n - 1;
                if (n % 3 != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        boolean b = solution.checkPowersOfThree(n);
        System.out.println(b);
        Assert.assertEquals(true, b);

        n = 91;
        b = solution.checkPowersOfThree(n);
        System.out.println(b);
        Assert.assertEquals(true, b);


        n = 21;
        b = solution.checkPowersOfThree(n);
        System.out.println(b);
        Assert.assertEquals(false, b);

    }
}
