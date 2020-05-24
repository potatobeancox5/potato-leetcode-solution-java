package com.potato.study.leetcode.p0927;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	927. Three Equal Parts
 *  
 *       Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.

If it is possible, return any [i, j] with i+1 < j, such that:

A[0], A[1], ..., A[i] is the first part;
A[i+1], A[i+2], ..., A[j-1] is the second part, and
A[j], A[j+1], ..., A[A.length - 1] is the third part.
All three parts have equal binary value.
If it is not possible, return [-1, -1].

Note that the entire part is used when considering what binary value it represents.  For example, [1,1,0] represents 6 in decimal, not 3.  Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.



Example 1:

Input: [1,0,1,0,1]
Output: [0,3]
Example 2:

Input: [1,1,0,1,1]
Output: [-1,-1]


Note:

3 <= A.length <= 30000
A[i] == 0 or A[i] == 1
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/three-equal-parts/solution/san-deng-fen-by-leetcode/
 *
 *
 * 
 */
public class Solution {


    public int[] threeEqualParts(int[] arr) {
        int[] imp = new int[]{-1, -1};
        int len = arr.length;

        int sum = 0;
        for (int x: arr) {
            sum += x;
        }
        if (sum % 3 != 0) {
            return imp;
        }
        int tt = sum / 3;
        if (tt == 0) {
            return new int[]{0, len - 1};
        }

        int i1 = -1;
        int j1 = -1;
        int i2 = -1;
        int j2 = -1;
        int i3 = -1;
        int j3 = -1;
        int su = 0;
        for (int i = 0; i < len; ++i) {
            if (arr[i] == 1) {
                su += 1;
                if (su == 1) {
                    i1 = i;
                }
                if (su == tt) {
                    j1 = i;
                }
                if (su == tt+1) {
                    i2 = i;
                }
                if (su == 2*tt) {
                    j2 = i;
                }
                if (su == 2*tt + 1) {
                    i3 = i;
                }
                if (su == 3*tt) {
                    j3 = i;
                }
            }
        }

        // The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
        // where [i1, j1] is a block of 1s, etc.
        int[] part1 = Arrays.copyOfRange(arr, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3+1);

        if (!Arrays.equals(part1, part2)) {
            return imp;
        }
        if (!Arrays.equals(part1, part3)) {
            return imp;
        }

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = arr.length - j3 - 1;

        if (x < z || y < z) {
            return imp;
        }
        return new int[]{j1+z, j2+z+1};
    }

    public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{1,0,1,0,1};
		int[] num = solution.threeEqualParts(arr);
        System.out.println(Arrays.toString(num));
    }
}
