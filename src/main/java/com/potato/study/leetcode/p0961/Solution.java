package com.potato.study.leetcode.p0961;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	961. N-Repeated Element in Size 2N Array
 *  
 *       In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.



Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5


Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even
 *         
 *         题目含义：
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int repeatedNTimes(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {1,2,3,3};
		int[] arr = {2,1,2,5,3,2};
        int result = solution.repeatedNTimes(arr);
        System.out.println(result);
    }
}
