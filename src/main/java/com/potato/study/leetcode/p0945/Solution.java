package com.potato.study.leetcode.p0945;

/**
 * 
 * @author liuzhao11
 * 
 * 	945. Minimum Increment to Make Array Unique
 *  
 *       Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.



Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.


Note:

0 <= A.length <= 40000
0 <= A[i] < 40000
 *         
 *         题目含义：
 *
 *         思路：
 *          https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/shi-shu-zu-wei-yi-de-zui-xiao-zeng-liang-by-leet-2/
 *
 *
 * 
 */
public class Solution {

    public int minIncrementForUnique(int[] array) {
        int[] count = new int[80000];
        for (int x: array) {
            count[x]++;
        }
        int ans = 0, taken = 0;
        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }
        return ans;
    }
}
