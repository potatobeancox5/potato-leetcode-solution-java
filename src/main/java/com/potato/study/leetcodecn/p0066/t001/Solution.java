package com.potato.study.leetcodecn.p0066.t001;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 直接加 1 维护一个 int process ，process + digit i
     * 2. 如果最高位需要进位 那么申请一个新数组
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        if (null == digits || digits.length == 0) {
            return digits;
        }
        digits[digits.length - 1]++;
        // 0 最后一位 + 1
        int process = 0;
        if (digits[digits.length - 1] >= 10) {
            digits[digits.length - 1] %= 10;
            process = 1;
        }
        // 1 直接加 1 维护一个 int process ，process + digit i
        for (int i = digits.length - 2; i >= 0 ; i--) {
            if (process == 0) {
                break;
            }
            digits[i] += process;
            if (digits[i] >= 10) {
                digits[i] %= 10;
                process = 1;
            } else {
                process = 0;
            }
        }

        // 2. 如果最高位需要进位 那么申请一个新数组
        if (process > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = process;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3};
        int[] res = solution.plusOne(arr);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(res, new int[]{1,2,4});


        arr = new int[]{4,3,2,1};
        res = solution.plusOne(arr);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(res, new int[]{4,3,2,2});


        arr = new int[]{8,9,9,9};
        res = solution.plusOne(arr);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(res, new int[]{9,0,0,0});
    }
}
