package com.potato.study.leetcode.p0941;

import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	941. Valid Mountain Array
 *  
 *       Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]




Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true


Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
 *         
 *         题目含义：
 *
 *
 *         思路：
 *
 *
 * 
 */
public class Solution {

    public boolean validMountainArray(int[] arr) {

        if (null == arr || arr.length < 3) {
            return false;
        }
        int left = 0;
        while (left < arr.length - 1 && arr[left] < arr[left+1]) {
            left++;
        }
        int right = arr.length -1;
        while (right > 0 && arr[right-1] > arr[right]){
            right--;
        }

        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = new int[]{2,1};
        boolean res = solution.validMountainArray(arr);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
