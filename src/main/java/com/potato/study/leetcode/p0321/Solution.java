package com.potato.study.leetcode.p0321;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author Administrator
 *
 *         321. Create Maximum Number
 *         
 *          
 *         Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.

Note: You should try to optimize your time and space complexity.

Example 1:

Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]
Example 2:

Input:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:
[6, 7, 6, 0, 4]
Example 3:

Input:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
Output:
[9, 8, 9]
 *         
 *         
 *         题目含义：
 *          从两个数字 找到 最大数字，数位已经确定 保证数字的相对位置不变
 *         思路： 
 *          321. Create Maximum Number
 *          https://blog.csdn.net/haoxiaoxiaoyu/article/details/79484656
 *
 *          我们可以分三步得到正确结果：
1：从nums1里取i个元素组成最大数组，从nums2里取k-i个元素组成最大数组。
2：合并之前结果，得到一个长度为k的最大数组。
3：对于不同长度分配的情况，比较每次得到的长度为k的最大数组，返回最大的一个。
三个不同的函数分别用于取，合并，比较。
 *         
 */
public class Solution {

    /**
     * 从 nums 1和 nums2 中找到k 个数保证 找到的数字顺序保持不变且 组合成的数字最大
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        1：从nums1里取i个元素组成最大数组，从nums2里取k-i个元素组成最大数组。
        int[] max = new int[k];
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i > nums1.length || j > nums2.length) {
                continue;
            }
            int[] greatestNum1 = getGreatestNum(nums1, i);
            int[] greatestNum2 = getGreatestNum(nums2, j);
//        2：合并之前结果，得到一个长度为k的最大数组。
            int[] mergeResult = mergeAndGetLarger(greatestNum1, greatestNum2);
//        3：对于不同长度分配的情况，比较每次得到的长度为k的最大数组，返回最大的一个。
            if (isGreaterThan(mergeResult, max, 0 , 0)) {
                max = mergeResult;
            }
        }
        return max;
    }



    /**
     * 从nums 找到 保持顺序不变的 最大的序列 保证组成的数字最大
     * 生成 bitCount 位最大的数
     * @param nums      原数组
     * @param bitCount  位数
     * @return
     */
    private int[] getGreatestNum (int[] nums, int bitCount) {
        if (bitCount == 0) {
            return new int[0];
        }
        int[] res = new int[bitCount];
        int resIndex = 0;
        /**
         *
         * 6个数字 区3个数字
         * 0 - 3 选一个最大的 index = k
         * k+1 - 4 选一个最大的 index = k
         * k+1 - 5 选一个最大的
         * 第一次 0 - len -
         */
        int currentMaxIndex = 0;

        for (int j = bitCount; j > 0; j--) {
            for (int i = currentMaxIndex + 1; i <= nums.length - j; i++) {
                if (nums[currentMaxIndex] < nums[i]) {
                    currentMaxIndex = i;
                }
            }
            res[resIndex++] = nums[currentMaxIndex++];
        }
        return res;
    }

    /**
     * 合并 并返回最大的数
     * 规则
     * 比较第一个位置 选择最大的
     * 比较第
     * @return
     */
    private int[] mergeAndGetLarger(int[] num1, int[] num2) {
        // 1. 申请len1 + len2 长度数组
        int totalLen = num1.length + num2.length;
        int[] res = new int[totalLen];
        // 2. i j 找到大的放到数组里，并向后移动
        int i = 0;
        int j = 0;
        int insertIndex = 0;
        while (i < num1.length || j < num2.length) {
            if (i < num1.length && j < num2.length) {
                res[insertIndex++] = (isGreaterThan(num1, num2, i, j) ? num1[i++] : num2[j++]);
            } else if (i < num1.length) {
                res[insertIndex++] = num1[i++];
            } else {
                // j < num2.length
                res[insertIndex++] = num2[j++];
            }
        }
        return res;
    }




    /**
     * 判断 mergeResult 是否比 max 大
     * @param a
     * @param b
     * @return
     */
    private boolean isGreaterThan(int[] a, int[] b, int i, int j) {
        // 如果i j 存在如果 i j 对应数字相等 i++, j++
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        // 如果 i 存在 j 不存在 那么 a > b 否则 如果 i 不存在 j 存在 那么 a < b 都不存在a = b
        if (i < a.length && j >= b.length) {
            return true;
        } else if (i >= a.length && j < b.length) {
            return false;
        } else if (i >= a.length && j >= b.length) {
            // 相等
            return false;
        } else {
            // 都存在 直接比较 ai - bj > 0 ?
            return a[i] - b[j] > 0;
        }
    }

    public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums1 = {3, 4, 6, 5};
		int[] nums2 = {9, 1, 2, 5, 8, 3};
		int k = 5;

        int[] greatestNum = solution.maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(greatestNum));
        int[] expected1 = {9, 8, 6, 5, 3};
        Assert.assertArrayEquals(expected1, greatestNum);


        int[] nums3 = {6, 7};
        int[] nums4 = {6, 0, 4};
        k = 5;

        greatestNum = solution.maxNumber(nums3, nums4, k);
        System.out.println(Arrays.toString(greatestNum));
        int[] expected2 = {6, 7, 6, 0, 4};
        Assert.assertArrayEquals(expected2, greatestNum);

        int[] nums5 = {3, 9};
        int[] nums6 = {8, 9};
        k = 3;
        greatestNum = solution.maxNumber(nums5, nums6, k);
        System.out.println(Arrays.toString(greatestNum));
        int[] expected3 = {9, 8, 9};
        Assert.assertArrayEquals(expected3, greatestNum);
    }
}
