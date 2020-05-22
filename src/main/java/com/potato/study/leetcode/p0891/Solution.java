package com.potato.study.leetcode.p0891;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author liuzhao11
 *
 * 891. Sum of Subsequence Widths
 *
 * Given an array of integers A, consider all non-empty subsequences of A.

For any sequence S, let the width of S be the difference between the maximum and minimum element of S.

Return the sum of the widths of all subsequences of A.

As the answer may be very large, return the answer modulo 10^9 + 7.



Example 1:

Input: [2,1,3]
Output: 6
Explanation:
Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.


Note:

1 <= A.length <= 20000
1 <= A[i] <= 20000
 *
 * 题目含义：
 *      https://leetcode-cn.com/problems/sum-of-subsequence-widths/solution/zi-xu-lie-kuan-du-zhi-he-shu-xue-fen-xi-by-jerring/
 *
 *
 */
public class Solution {

    public int sumSubseqWidths(int[] arr) {

        int mod = (int) (1e9 + 7);
        Arrays.sort(arr);
        int n = arr.length;
        long res = 0;
        long p = 1;
        for (int i = 0; i < n; ++i) {
            res = (res + (arr[i] - arr[n - 1 - i]) * p) % mod;
            p = (p << 1) % mod;
        }
        return (int) ((res + mod) % mod);
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = new int[]{2,1,3};
        int res = solution.sumSubseqWidths(arr);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
