package com.potato.study.leetcode.p0932;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	932. Beautiful Array
For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

Given N, return any beautiful array A.  (It is guaranteed that one exists.)



Example 1:

Input: 4
Output: [2,1,4,3]
Example 2:

Input: 5
Output: [3,1,2,5,4]


Note:

1 <= N <= 1000
 *         
 *         题目含义：
 *
 *         思路：
 *         https://www.jianshu.com/p/6b9dc1ecdf1d
 *
 *          对于某个 位置  左边都放奇数 右边都放偶数就可以
 *
 *
 * 
 */
public class Solution {
    // 前 n 个数字的安排
    private Map<Integer, int[]> cache;

    public int[] beautifulArray(int n) {
        cache = new HashMap<>();
        return getBeautifulArray(n);
    }

    /**
     * 递归生成数组
     * @param n
     * @return
     */
    private int[] getBeautifulArray(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int index = 0;
            for (int ele : getBeautifulArray((n+1) / 2)) {
                res[index] = 2 * ele - 1;
                index++;
            }

            for (int ele : getBeautifulArray(n / 2)) {
                res[index] = 2 * ele;
                index++;
            }
        }

        cache.put(n, res);
        return res;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 4;
		int[] num = solution.beautifulArray(n);
        System.out.println(Arrays.toString(num)); // [2,1,4,3]
    }
}
