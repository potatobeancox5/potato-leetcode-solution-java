package com.potato.study.leetcode.p0962;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	962. Maximum Width Ramp
 *  
 *       Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.



Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation:
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation:
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.


Note:

2 <= A.length <= 50000
0 <= A[i] <= 50000
 *         
 *         题目含义：
 *          https://leetcode-cn.com/problems/maximum-width-ramp/solution/zui-da-kuan-du-po-by-leetcode/
 *
 *
 *
 * 
 */
public class Solution {

    public int maxWidthRamp(int[] arr) {
        int len = arr.length;
        Integer[] bbb = new Integer[len];
        for (int i = 0; i < len; ++i)
            bbb[i] = i;

        Arrays.sort(bbb, (i, j) -> ((Integer) arr[i]).compareTo(arr[j]));

        int ans = 0;
        int m = len;
        for (int i: bbb) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }



}
