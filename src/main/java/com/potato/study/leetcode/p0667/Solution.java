package com.potato.study.leetcode.p0667;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         667. Beautiful Arrangement II
 * 
 *         Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
Example 2:
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
Note:
The n and k are in the range 1 <= k < n <= 104.
 *
 *
 *
 *         思路：
 *
 *         给定n个整数，求一组排列 使得 [a1, a2, a3, ... , an]
 *         构造的list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 *         还有 k 个不相等的数字
 *
 *         https://www.jianshu.com/p/26f16463339f
 *
 *         规律 将 n 拆分成 【1 ， k-1】 & 【k，n】
 *
 *
 */
public class Solution {

    public int[] constructArray(int n, int k) {
        // 0. 创建返回值数组
        int[] res = new int[n];
        // 1. 防止 0 ， 0 - k
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            res[index] = i;
            index++;
        }
        // 2. 剩下的数 按照奇偶进行设置
        for (int i = 0; i <= k; i++) {
            // 偶数
            if (i % 2 == 0) {
                res[index] = i / 2 + n - k;
            } else {
                // 奇数
                res[index] = n - i / 2;
            }
            index++;
        }
        return res;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 3;
        int k = 1;
        int[] result = solution.constructArray(n, k);
        // 1, 2, 3
        System.out.println(Arrays.toString(result));
    }
}
