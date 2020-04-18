package com.potato.study.leetcode.p0896;


import org.junit.Assert;

/**
 * @author liuzhao11
 *
 *
 * 896. Monotonic Array
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.



Example 1:

Input: [1,2,2,3]
Output: true
Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
Example 4:

Input: [1,2,4,5]
Output: true
Example 5:

Input: [1,1,1]
Output: true


Note:

1 <= A.length <= 50000
-100000 <= A[i] <= 100000 *


题目含义：
 * <p>
 *
 * 思路：
 *
 *    https://www.cnblogs.com/grandyang/p/10961560.html
 *
 */
public class Solution {
    public boolean isMonotonic(int[] arr) {

        if (arr.length <= 2) {
            return true;
        }
        boolean isAsc = true;
        boolean isDesc = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                isDesc = false;
            } else if (arr[i] < arr[i-1]) {
                isAsc = false;
            }
            if (!isAsc && !isDesc) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1,2,2,3};
        boolean res = solution.isMonotonic(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{6,5,4,4};
        res = solution.isMonotonic(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{1,3,2};
        res = solution.isMonotonic(arr);
        System.out.println(res);
        Assert.assertEquals(false, res);

        arr = new int[]{1,2,4,5};
        res = solution.isMonotonic(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);


        arr = new int[]{1,1,1};
        res = solution.isMonotonic(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
