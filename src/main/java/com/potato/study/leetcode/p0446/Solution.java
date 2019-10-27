package com.potato.study.leetcode.p0446;

import com.potato.study.leetcode.domain.ListNode;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *   446. Arithmetic Slices II - Subsequence
 * 
 *    A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A.

The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.


Example:

Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]

 *
 *     题目含义：
 *      算出数列中 等差子序列的个数
 *
 *     思路：
 *      https://segmentfault.com/a/1190000020698435?utm_source=tag-newest
 *
 *
 *      https://blog.csdn.net/wdlsjdl2/article/details/53147146
 *
 *      dp[i][j]表示以A[i]结尾的子序列(P0, P1, ..., Pi)构成的subsequence slices，序列中的元素之差为j

        方程dp[i][j]=dp[k][j]>0?dp[k][j]+1:1     0<=i<A.length()     0<=k<i
 *
 *
 *      dp[i][j] 对应 map[i].get(j)
 *
 *      dp 是种类数 可以推导一下，确实只增加了1
 *
 *     
 * 			
 * 	
 */	
public class Solution {

    public int numberOfArithmeticSlices(int[] arr) {

        Map<Integer, Integer>[] map = new Map[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            // 初始化map
            map[i] = new HashMap<>();
            int num = arr[i];
            for (int j = 0; j < i; j++) {
                // 差不能 太大或者太小
                if ((long)num - arr[j] > Integer.MAX_VALUE) {
                    continue;
                }
                if ((long)num - arr[j] < Integer.MIN_VALUE) {
                    continue;
                }
                int difference = num - arr[j];
                int count = map[j].get(difference) != null ? map[j].get(difference) : 0;
                map[i].put(difference, (map[i].get(difference) != null ? map[i].get(difference) : 0) + count + 1);
                res += count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 4, 6, 8, 10};


        int count = solution.numberOfArithmeticSlices(arr);
        System.out.println(count);
        Assert.assertEquals(7, count);
    }
}
