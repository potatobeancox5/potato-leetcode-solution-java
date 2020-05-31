package com.potato.study.leetcode.p1018;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1018. Binary Prefix Divisible By 5
 *  
 *         Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)

Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

Example 1:

Input: [0,1,1]
Output: [true,false,false]
Explanation:
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
Example 2:

Input: [1,1,1]
Output: [false,false,false]
Example 3:

Input: [0,1,1,1,1,1]
Output: [true,false,false,false,true,false]
Example 4:

Input: [1,1,1,0,1]
Output: [false,false,false,false,false]


Note:

1 <= A.length <= 30000
A[i] is 0 or 1
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/solution/gei-chu-xue-de-xiao-bai-jiang-jie-by-xiao-vvvvvv/
 *
 *
 */
public class Solution {

    public List<Boolean> prefixesDivBy5(int[] arr) {
        int num = 0;
        List<Boolean> ans = new ArrayList<>();
        for(int index=0;index<arr.length;index++){
            num = (num*2+arr[index])%5;
            if(num==0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
