package com.potato.study.leetcode.p0852;

/**
 * 
 * @author liuzhao11
 * 
 * 	852. Peak Index in a Mountain Array
 *  
 *         Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
 *         
 *
 *         题目含义：
 *            找到一个一个山脉数组的最大值，山脉数组见英文定义吧
 *         思路：
 *            二分查找  A.length >= 3
 *            left = 0 right = len - 1
 *            while left <= right
 *              mid = left + right / 2
 *              if mid - 1 < mid < mid + 1
 *                  left = mid +1
 *              else if mid - 1 > mid > mid + 1
 *                  ri = mid - 1
 *              else if mid - 1 < mid > mid + 1
 *                  retuen mid
 *              else  异常 不符合定义
 *
 *
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                // mid - 1 < mid < mid + 1
                left = mid + 1;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                // mid - 1 > mid > mid + 1
                right = mid - 1;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                //  mid - 1 < mid > mid + 1
                return mid;
            } else { // 异常

            }
        }
        return -1;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {0,1,0};
//		int[] arr = {3,4,5,1};
		int[] arr = {18,29,38,59,98,100,99,98,90};
        int result = solution.peakIndexInMountainArray(arr);
        System.out.println(result);
    }
}
