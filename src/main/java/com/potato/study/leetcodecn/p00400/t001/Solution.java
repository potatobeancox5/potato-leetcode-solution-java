package com.potato.study.leetcodecn.p00400.t001;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * 400. 第 N 位数字
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 *
 *  
 *
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 * 示例 2：
 *
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        // 确定 n位置所在的数字 是几位数的 1-9 9*1数字   10 - 99 90个数 90*2个数字   100-999  900*3 个数字
        if (n < 10) {
            return n;
        }
        // 当前个数数字 总共有多少个位置  9 - 90，900
        int bitTotalCount = 9;
        // 找到第几位数字了
        int bitCount = 1;
        int start = 1;
        int tmp = n;
        while (tmp >= bitTotalCount) {
            tmp -= bitTotalCount;
            bitTotalCount *= 10;
            bitCount++;
            start *= 10;
            bitTotalCount *= bitCount;
        }
        // 当前n 在 bitCount 里边 ，看下是哪个数字
        int num = tmp / bitCount + start;
        // 看下是这个数字的第几个位置
        int position = tmp % bitCount;
        if (position == 0) {
            num--;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int res;
        if (position == 0) {
            // 返回 最后一个位置
            res = chars[chars.length - 1] - '0';
        } else {
            // 返回 position -1 位置
            res = chars[position - 1] - '0';
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int res = solution.findNthDigit(n);
        System.out.println(res);
        Assert.assertEquals(3, res);

        n = 11;
        res = solution.findNthDigit(n);
        System.out.println(res);
        Assert.assertEquals(0, res);

        n = 10;
        res = solution.findNthDigit(n);
        System.out.println(res);
        Assert.assertEquals(1, res);

        n = 10000;
        res = solution.findNthDigit(n);
        System.out.println(res);
        Assert.assertEquals(7, res);
    }



}
