package com.potato.study.leetcode.p0775;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	775. Global and Local Inversions
 *  
 *        We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

Return true if and only if the number of global inversions is equal to the number of local inversions.

Example 1:

Input: A = [1,0,2]
Output: true
Explanation: There is 1 global inversion, and 1 local inversion.
Example 2:

Input: A = [1,2,0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.
Note:

A will be a permutation of [0, 1, ..., A.length - 1].
A will have length in range [1, 5000].
The time limit for this problem has been reduced.
 *         
 *         思路：
 *          https://blog.csdn.net/liuchuo/article/details/79195105
 *
 *
 * 
 */
public class Solution {

    /**
     * 因为相邻的倒转 属于 全局倒转 所以 true的条件是 只有局部倒转
     * 使用max 计算当前最大值 如果其 比 i + 2 还大 说明返回false
     * @param arr
     * @return
     */
    public boolean isIdealPermutation(int[] arr) {

        if(arr.length <= 2) {
            return true;
        }

        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            max = Math.max(max, arr[i]);
            if (max > arr[i + 2]) {
                return false;
            }
        }
        return true;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();


        int[] arr = {1,0,2};
        boolean res = solution.isIdealPermutation(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{1,2,0};
        res = solution.isIdealPermutation(arr);
        System.out.println(res);
        Assert.assertEquals(false, res);

    }
}
