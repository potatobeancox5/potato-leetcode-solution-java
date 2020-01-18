package com.potato.study.leetcode.p0672;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         672. Bulb Switcher II
 * 
 *         There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.

Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:

Flip all the lights.
Flip lights with even numbers.
Flip lights with odd numbers.
Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...


Example 1:

Input: n = 1, m = 1.
Output: 2
Explanation: Status can be: [on], [off]


Example 2:

Input: n = 2, m = 1.
Output: 3
Explanation: Status can be: [on, off], [off, on], [off, off]


Example 3:

Input: n = 3, m = 1.
Output: 4
Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].


Note: n and m both fit in range [0, 1000].
 *
 *
 *
 *         思路：
 *
 *         n 盏灯 m 个操作 操作完了之后的状态
 *
 *
 * https://www.cnblogs.com/qiulinzhang/p/9514425.html
 * https://blog.csdn.net/huanghanqian/article/details/77857912
 *
 *
 *
 *
 *
 *
 */
public class Solution {

    public int flipLights(int n, int m) {

        if (n == 0 || m ==0) {
            // 情况 1 一个等也没有 那么只有1种情况
            return 1;
        } else if (n == 1) {
            // 情况2 只有一盏灯 那么只有2种情况 灭 或者亮
            return  2;
        } else if (n == 2 && m == 1) {
            // 情况3 2盏等 1次操作  [on, off], [off, on], [off, off]
            return 3;
        } else if (n == 2 || m == 1) {
            // 情况4 2盏灯 或者2盏灯以上 一次操作
            return 4;
        } else if (m == 2) {
            // 情况4 2次操作
            return 7;
        } else {
            return 8;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1;
        int m = 1;
        int value = solution.flipLights(n, m);
        System.out.println(value);
        Assert.assertEquals(2, value);

        n = 2;
        m = 1;
        value = solution.flipLights(n, m);
        System.out.println(value);
        Assert.assertEquals(3, value);

        n = 3;
        m = 1;
        value = solution.flipLights(n, m);
        System.out.println(value);
        Assert.assertEquals(4, value);
    }
}
