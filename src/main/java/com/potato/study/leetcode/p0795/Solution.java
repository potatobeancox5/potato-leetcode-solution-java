package com.potato.study.leetcode.p0795;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	795. Number of Subarrays with Bounded Maximum
 *  
 *        We are given an array A of positive integers,
 *        and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that
the value of the maximum array element in that subarray is at least L and at most R.

Example :
Input:
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Note:

L, R  and A[i] will be an integer in the range [0, 10^9].
The length of A will be in the range of [1, 50000].
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         https://blog.csdn.net/magicbean2/article/details/79761755
 *
 *         维护一个 left right 是合法区间，
 *         left = 0 right = 0
 *
 *         遍历 right 0 len 如果在 left和righ中 total += right - left + 1 count = right - left + 1
 *         如果 小于 L  total += count
 *         否则 （大于 R） count = 0 left = right+1
 *
 *
 *
 * 
 */
public class Solution {

    public int numSubarrayBoundedMax(int[] arr, int l, int r) {
        int left = 0;
        int total = 0;
        int count = 0;
        for (int right = 0; right < arr.length; right++) {
            if (l <= arr[right] && arr[right] <= r) {
                count = right - left + 1;
                total += (right - left + 1);
            } else if (l > arr[right]) {
                total += count;
            } else {
                // （大于 R）
                count = 0;
                left = right + 1;
            }
        }
        return total;
    }




	

	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{2, 1, 4, 3};
        int l = 2;
        int r = 3;
        int res = solution.numSubarrayBoundedMax(arr, l, r);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
