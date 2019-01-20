package com.potato.study.leetcode.p0905;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	905. Sort Array By Parity
 *  
 *       Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
 *         
 *         题目含义：
 *          将偶数放在前边
 *         思路：
 *          前后指针交换
 *          left 记录左边的odd 位置
 *          right 记录右边的even 位置
 *          如果 left > right 时 结束比较
 *
 *
 */
public class Solution {

    public int[] sortArrayByParity(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // 找到right 指向的偶数位置
            while (left <= right && arr[right] % 2 == 1) {
                right--;
            }
            // 找到left 指向的奇数位置
            while (left <= right && arr[left] % 2 == 0) {
                left++;
            }
            // 交换
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        return arr;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {3,1,2,4};
        int[] result = solution.sortArrayByParity(arr);
        System.out.println(Arrays.toString(result));
    }
}
