package com.potato.study.leetcode.p0670;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         670. Maximum Swap
 * 
 *         Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
 *
 *
 *
 *         思路：
 *         给定一个 非负 整数 只能交换一次 一次交换2个数字，求能得到的最大数字
 *
 *
 *
 */
public class Solution {

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] numArr = numStr.toCharArray();
        // 1. 从每个位置开始进行遍历
        for (int i = 0; i < numArr.length - 1; i++) {
            // 2. 从之后的位置开始遍历 找到最大值，找到了 进行交换
            int maxIndex = numArr.length - 1;
            for (int j = numArr.length - 1; j >= i+1; j--) {
                if (numArr[maxIndex] < numArr[j]) {
                    maxIndex = j;
                }
            }
            // 交换数字 并直接返回
            if (numArr[maxIndex] > numArr[i]) {
                char ch = numArr[i];
                numArr[i] = numArr[maxIndex];
                numArr[maxIndex] = ch;
                return Integer.parseInt(new String(numArr));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 2736;
        int value = solution.maximumSwap(num);
        System.out.println(value);
        Assert.assertEquals(7236, value);

        num = 9973;
        value = solution.maximumSwap(num);
        System.out.println(value);
        Assert.assertEquals(9973, value);

        num = 98368;
        value = solution.maximumSwap(num);
        System.out.println(value);
        Assert.assertEquals(98863, value);

        num = 1993;
        value = solution.maximumSwap(num);
        System.out.println(value);
        Assert.assertEquals(9913, value);
    }
}
