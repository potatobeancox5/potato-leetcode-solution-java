package com.potato.study.leetcode.p0868;

/**
 * 
 * @author liuzhao11
 * 
 * 	868. Binary Gap
 *  
 *         Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

If there aren't two consecutive 1's, return 0.



Example 1:

Input: 22
Output: 2
Explanation:
22 in binary is 0b10110.
In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
The first consecutive pair of 1's have distance 2.
The second consecutive pair of 1's have distance 1.
The answer is the largest of these two distances, which is 2.
Example 2:

Input: 5
Output: 2
Explanation:
5 in binary is 0b101.
Example 3:

Input: 6
Output: 1
Explanation:
6 in binary is 0b110.
Example 4:

Input: 8
Output: 0
Explanation:
8 in binary is 0b1000.
There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.


Note:

1 <= N <= 10^9
 *         
 *
 *         题目含义：
 *              给一个数，转换成二进制，求两个1之间最多有多少0

 *         思路：
 *           记录当前距离 dis = 0， maxdis = 0;
 *           index 记录当前index preIndex 记录之前 1的index
 *           对 n && 1 结果为 1   dis = index - preindex 求最大值 preIndex = index   n >> 1 index++
 *
 *
 */
public class Solution {
    public int binaryGap(int n) {
        int maxDistance = 0;
        int index = 0;
        int preindex = -1;
        while (n !=  0) {
            if ((n & 1) == 1) {
                if (preindex != -1) {
                    int dis = index - preindex;
                    if (maxDistance < dis) {
                        maxDistance = dis;
                    }
                }
                preindex = index;
            }
            index++;
            n = n >> 1;
        }
        return maxDistance;
    }

    public static void main(String[] args) {
//        System.out.println(4>>>1);
        Solution solution = new Solution();
        int n = 8;
        int gap = solution.binaryGap(n);
        System.out.println(gap);
    }
}
