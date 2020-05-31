package com.potato.study.leetcode.p1014;


/**
 * 
 * @author liuzhao11
 * 
 * 	1014. Best Sightseeing Pair
 *  
 *         Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.

The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.



Example 1:

Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11


Note:

2 <= A.length <= 50000
1 <= A[i] <= 1000
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/best-sightseeing-pair/solution/jian-dan-rong-yi-li-jie-by-sylilancanlions/
 */
public class Solution {


    public int maxScoreSightseeingPair(int[] arr) {
        int left = arr[0] + 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<arr.length;i++){
            max = Math.max(max,arr[i]-i+left);
            left = Math.max(left,arr[i]+i);
        }
        return max;
    }
}
