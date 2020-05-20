package com.potato.study.leetcode.p0873;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhao11
 *
 * 873. Length of Longest Fibonacci Subsequence
 *
 *
 *
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)



Example 1:

Input: [1,2,3,4,5,6,7,8]
Output: 5
Explanation:
The longest subsequence that is fibonacci-like: [1,2,3,5,8].
Example 2:

Input: [1,3,7,11,12,14,18]
Output: 3
Explanation:
The longest subsequence that is fibonacci-like:
[1,11,12], [3,11,14] or [7,11,18].


Note:

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
(The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 *
 *
 * 题目含义：
 *  https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/solution/dpijyi-aiajjie-wei-de-zui-chang-fei-bo-na-qi-zi-xu/
 *
 * 思路：
 *
 *  设dp[i][j]表示以(A[i],A[j])结尾的最长斐波那契子序列的长度，初始化为2，因为斐波那契序列最短为3
状态转移方程：
dp[i][j]=dp[k][i]+1...if A[k]+A[i]==A[j]且k<i
 *
 *
 */
public class Solution {

    public int lenLongestFibSubseq(int[] arr) {

        int[][] dp = new int[arr.length][arr.length];
        // init dp 2
        Map<Integer, Integer> value2IndexMap = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 2);
            value2IndexMap.put(arr[i], i);
        }
        // for i j  找到k
        int maxLen = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int target = arr[j] - arr[i];
                // 如果存在 找到 key 判断 key 与 i关系
                if (value2IndexMap.containsKey(target)) {
                    int index = value2IndexMap.get(target);
                    if (index < i) {
                        dp[i][j] = dp[index][i] + 1;
                    }
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }

        }
        return maxLen > 2 ? maxLen : 0;
    }




    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int res = solution.lenLongestFibSubseq(arr);
        System.out.println(res);
        Assert.assertEquals(5, res);


        arr = new int[]{1,3,7,11,12,14,18};
        res = solution.lenLongestFibSubseq(arr);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
