package com.potato.study.leetcode.p0805;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	805. Split Array With Same Average
 *  
 *         In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)

Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.

Example :
Input:
[1,2,3,4,5,6,7,8]
Output: true
Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
Note:

The length of A will be in the range [1, 30].
A[i] will be in the range of [0, 10000].
 *         
 *         思路：
 *          将一个list 拆成2个 每个平均值相等 返回true 否则 false
https://blog.csdn.net/tiefanhe/article/details/80155809
详细的注释
 *
 * 
 */
public class Solution {

    public boolean splitArraySameAverage(int[] arr) {

        // 计算原始数组 sum 对原始数组排序
        if (arr.length == 1) {
            return false;
        }

        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // 对于每一个 长度的新数组1 进行遍历 知道 愿数组 len / 2
        // 如果 sum 原来数组 * lenNew % arr len == 0 且  递归查找arr中，是否存在len个元素，使得其和为 (sum * len) / A.length（均值相同）
        for (int len = 1; len <= arr.length / 2; len++) {
            if ( (sum * len) % arr.length == 0 && hasValidSplit(arr, len, (sum * len) / arr.length, 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归查找 是否有 targetLen 个数组 满足均值参数等于 targetSum
     * @param arr
     * @param targetLen
     * @param targetSum
     * @param startIndex
     * @return
     */
    private boolean hasValidSplit(int[] arr, int targetLen, int targetSum, int startIndex) {
        // 递归结束 条件 没有要找的len为0 且判断要找的sum 是不是也是0
        if (targetLen == 0) {
            return targetSum == 0;
        }
        // as the array is sorted
        if (arr[startIndex] > targetSum) {
            return false;
        }

        for (int i = startIndex; i < arr.length - targetLen + 1; i++) {
            if (i > startIndex && arr[i] == arr[i-1]) {
                continue;
            }
            if (hasValidSplit(arr, targetLen-1, targetSum - arr[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8};
        boolean result = solution.splitArraySameAverage(arr);
        System.out.println(result);
        Assert.assertEquals(true, result);


        arr = new int[]{18,10,5,3};
        result = solution.splitArraySameAverage(arr);
        System.out.println(result);
        Assert.assertEquals(false, result);
    }
}
