package com.potato.study.leetcode.p0396;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       396. Rotate Function
 * 
 *     Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *         
 *         思路：
 *          直接算么
 *          其实有公式
 *          https://blog.csdn.net/vipin_pei/article/details/52539260
 *          S(new) = S(old) + { S - A[n-1]  - (n-1)*A[n-1] } = S(old)  + { S - n*A[n-1] };  //  S = A[0]+A[2]+A[3]+...+A[n]
 *
 *
 *         
 */
public class Solution {

    public int maxRotateFunction(int[] arr) {
        // 1. 计算s和
        int s = 0;
        int sOld = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            s += num;
            sOld += num * i;
        }
        // 2. 开始循环找最大值
        int max = sOld;
        for (int i = arr.length - 1; i >= 0; i--) {
            sOld = sOld + (s - arr.length * arr[i]);
            max = Math.max(max, sOld);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 3, 2, 6};
        int res = solution.maxRotateFunction(arr);
        System.out.println(res);
        Assert.assertEquals(26, res);

    }
}

