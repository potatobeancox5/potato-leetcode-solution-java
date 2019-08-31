package com.potato.study.leetcode.p0321;


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
     * 生成bitCount 位最大的数
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

        // 如果某一个直接是 空 直接返回另外一个
        if (num1.length == 0 && num2.length == 0) {
            return new int[0];
        }

        if (num1.length == 0) {
            return num2;
        }

        if (num2.length == 0) {
            return num1;
        }

        int[] res = new int[num1.length + num2.length];
        int index = 0;

        while (true) {

        }


    }



    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        return null;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums = {6, 0, 4};
		int k = 2;

        int[] greatestNum = solution.getGreatestNum(nums, k);
        System.out.println(Arrays.toString(greatestNum));
    }
}
