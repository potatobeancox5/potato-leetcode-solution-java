package com.potato.study.leetcode.p0977;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	977. Squares of a Sorted Array
 *  
 *         Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 *         
 *         思路：
 *         二分法找到0点 或者正负数的分界点
 *         存在0点则 0点 插入，
 *          剩下的情况从比较正负节点平方 然后插入
 */
public class Solution {

    public int[] sortedSquares(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {2,1,2};
//		int[] arr = {1,2,1};
		int[] arr = {-4,-1,0,3,10};
        int[] result = solution.sortedSquares(arr);
        System.out.println(Arrays.toString(result));
    }
}
