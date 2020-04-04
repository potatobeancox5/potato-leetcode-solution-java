package com.potato.study.leetcode.p0989;


import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	989. Add to Array-Form of Integer
 *  
 *         For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.



Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000


Note：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
If A.length > 1, then A[0] != 0
 *         
 *         思路：
 *
 *
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] arr, int k) {

        List<Integer> result = new LinkedList<>();

        int carry = 0;

        for (int i = arr.length -1; i >= 0; i--) {
            int num1 = arr[i];
            int num2 = k % 10;
            k /= 10;
            int value = num1 + num2 + carry;
            result.add(0, value % 10);
            carry = value / 10;
        }

        while (k > 0) {
            int num = k % 10;
            int value = num + carry;
            result.add(0, value % 10);
            carry = value / 10;
            k /= 10;
        }

        if (carry > 0) {
            result.add(0, carry);
        }

        return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = new int[]{1,2,0,0} ;
        int k = 34;
        List<Integer> list = solution.addToArrayForm(arr, k);
        System.out.println(list); // 1234

        arr = new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3} ;
        k = 516;
        list = solution.addToArrayForm(arr, k);
        System.out.println(list); // 1234


        arr = new int[]{0} ;
        k = 516;
        list = solution.addToArrayForm(arr, k);
        System.out.println(list); // 1234
    }
}