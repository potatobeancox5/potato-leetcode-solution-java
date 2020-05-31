package com.potato.study.leetcode.p0978;

/**
 * 
 * @author liuzhao11
 * 
 * 	978. Longest Turbulent Subarray
 *  
 *         A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.



Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
Example 2:

Input: [4,8,12,16]
Output: 2
Example 3:

Input: [100]
Output: 1


Note:

1 <= A.length <= 40000
0 <= A[i] <= 10^9
 *         
 *         思路：
 *
 */
public class Solution {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }

        int length = arr.length;
        int[] f = new int[length+1];
        int[] g = new int[length+1];
        f[1] = 1;
        g[1] = 1;

        int res = 1;
        for (int k = 2; k <= length; k++) {
            if (arr[k-1] > arr[k-2]) {
                f[k] = g[k-1] + 1;
            } else {
                f[k] = 1;
            }
            if (arr[k-1] < arr[k-2]) {
                g[k] = f[k-1] + 1;
            } else {
                g[k] = 1;
            }
            res = Math.max(res, f[k]);
            res = Math.max(res, g[k]);
        }
        return res;
    }
}
