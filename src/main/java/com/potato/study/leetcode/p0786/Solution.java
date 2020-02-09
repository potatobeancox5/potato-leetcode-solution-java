package com.potato.study.leetcode.p0786;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	786. K-th Smallest Prime Fraction
 *  
 *        A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.

What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

Examples:
Input: A = [1, 2, 3, 5], K = 3
Output: [2, 5]
Explanation:
The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
The third fraction is 2/5.

Input: A = [1, 7], K = 1
Output: [1, 7]
Note:

A will have length between 2 and 2000.
Each A[i] will be between 1 and 30000.
K will be between 1 and A.length * (A.length - 1) / 2.


 *
 *
 *   解题思路：
 *
 * 
 */
public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        return null;

    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] list = solution.kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(list)); // 2, 5

        int[] arr1 = {1, 7};
        k = 1;
        list = solution.kthSmallestPrimeFraction(arr1, k);
        System.out.println(Arrays.toString(list)); // 1, 7
    }
}
