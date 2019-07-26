package com.potato.study.leetcode.p0754;

/**
 * 
 * @author liuzhao11
 * 
 * 	754. Reach a Number
 *  
 *         You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].


 *   解题思路：
 *      求绝对值
 *      依次求和 如果和等于target 返回int
 *      否则 sum - target = 偶数时，返回int
 *
 * 
 */
public class Solution {


    public int reachNumber(int target) {

        target = Math.abs(target);

        int sum = 0;
        int n = 1;
        while (true) {
            sum += n;
            if (sum > target && (sum - target) % 2 == 0) {
                return n;
            } else if (target == sum) {
                return n;
            }
            n++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int target = 10;
        int count = solution.reachNumber(target);
        System.out.println("count:" + count);
    }
}
