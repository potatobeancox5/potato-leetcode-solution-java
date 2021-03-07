package com.potato.study.leetcodecn.p00231.t001;

import org.junit.Assert;

/**
 * 231. 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 示例 3:

 输入: 218
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-two
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 判断是不是2的mi
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int bit = 1;
        while (bit > 0) {
            if ((n | bit) == bit) {
                return true;
            }
            bit <<= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean powerOfTwo = solution.isPowerOfTwo(1);
        System.out.println(powerOfTwo);
        Assert.assertEquals(true, powerOfTwo);

        powerOfTwo = solution.isPowerOfTwo(16);
        System.out.println(powerOfTwo);
        Assert.assertEquals(true, powerOfTwo);

        powerOfTwo = solution.isPowerOfTwo(218);
        System.out.println(powerOfTwo);
        Assert.assertEquals(false, powerOfTwo);
    }

}
