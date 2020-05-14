package com.potato.study.leetcode.p0869;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	869. Reordered Power of 2
 *  
 *         Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.



Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true


Note:

1 <= N <= 10^9
 *         
 *
 *         题目含义：
 *          将数字重新排序 是否能得到一个2的幂

 *         思路：
 *          对n计数 然后对 2的每个位置进行比较
 *
 *
 *          https://leetcode-cn.com/problems/reordered-power-of-2/solution/zhong-xin-pai-xu-de-dao-2-de-mi-by-leetcode/
 *
 */
public class Solution {

    /**
     *
     * @param n
     * @return
     */
    public boolean reorderedPowerOf2(int n) {
        int[] target = this.countBit(n);
        for (int i = 0; i < 32; i++) {
            if (arrayEquals(target, countBit(1 << i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 比较 两个数组是够相等
     * @param arr1
     * @param arr2
     * @return
     */
    private boolean arrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对于一个 10 进制的数 统计每个数字出现的次数
     * @param n
     * @return
     */
    private int[] countBit(int n) {
        // 0 - 9
        int[] count = new int[10];
        if (n == 0) {
            count[0]++;
            return count;
        }
        while (n > 0) {
            int bit = n % 10;
            count[bit]++;
            n /= 10;
        }
        return count;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int n = 1;
        boolean res = solution.reorderedPowerOf2(n);
        System.out.println(res);
        Assert.assertEquals(res, true);

        n = 10;
        res = solution.reorderedPowerOf2(n);
        System.out.println(res);
        Assert.assertEquals(res, false);

        n = 16;
        res = solution.reorderedPowerOf2(n);
        System.out.println(res);
        Assert.assertEquals(res, true);

        n = 24;
        res = solution.reorderedPowerOf2(n);
        System.out.println(res);
        Assert.assertEquals(res, false);
    }
}
