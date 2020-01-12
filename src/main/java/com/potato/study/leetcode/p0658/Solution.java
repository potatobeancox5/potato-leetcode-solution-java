package com.potato.study.leetcode.p0658;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         658. Find K Closest Elements
 * 
 *         Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
UPDATE (2017/9/19):
The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.
 *         思路：
 *
 *         给定数字 x 找到距离x 最近的 k个数字
 *
 *         https://www.cnblogs.com/lightwindy/p/9741490.html

由于数组有序，所以最后找到的k个元素也一定是有序的，其实就是返回了一个长度为k的子数组，相当于在长度为n的数组中去掉n-k个数字，而且去掉的顺序肯定是从两头开始去，因为距离x最远的数字肯定在首尾出现。每次比较首尾两个数字跟x的距离，将距离大的那个数字删除，直到剩余的数组长度为k为止。

// 计算能去掉的 n-k 个数字是多少

left  < right

分别从两边开始 选择距离大的 删除 ，直到 删除的个数 等于 n - k，如果距离相等 先删除 大的
将 left 到 right 中间的数字  放到结果中
 *
 *
 */
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // 1.计算要 去掉 len - k 个数字是多少
        int deleteNum = arr.length - k;

        // 2.左边和右边一次删去 知道删除的数字等于 len - k
        int left = 0;
        int right = arr.length - 1;
        int currentDelete = 0;
        while (left <= right && currentDelete < deleteNum) {
            int leftDistance = Math.abs(arr[left] - x);
            int rightDistance = Math.abs(arr[right] - x);

            if (leftDistance > rightDistance) {
                left++;
                currentDelete++;
            } else {
                // leftDistance >= rightDistance 删除右边
                right--;
                currentDelete++;
            }
        }
        // 3. 构造结果
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        List<Integer> result = solution.findClosestElements(arr, k, x);
        System.out.println(result); // 1,2,3,4


        x = -1;
        result = solution.findClosestElements(arr, k, x);
        System.out.println(result); // 1,2,3,4
    }
}
