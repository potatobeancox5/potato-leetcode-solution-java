package com.potato.study.leetcode.p0762;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	762. Prime Number of Set Bits in Binary Representation
 *  
 *         Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Note:

L, R will be integers L <= R in the range [1, 10^6].
R - L will be at most 10000.


 *   题目大意：
 *
 *
 *   解题思路：
 *      https://www.jianshu.com/p/ca8d4bcea632
        首先判断20以内的素数 找到
        遍历每个数 利用移位 判断有多少个1
 * 
 */
public class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primeSet = new HashSet<>();
        primeSet.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
        int total = 0; // 记录总的1的数量为素数的个数
        for (int i = left; i <= right; i++) {
            int count = 0;
            int tmp = i;
            while (tmp > 0) {
                if ((tmp & 1) == 1) {
                    count++;
                }
                tmp = tmp >> 1;
            }
            if (primeSet.contains(count)) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int left = 6;
        int right = 10;
        int count = solution.countPrimeSetBits(left, right);
        System.out.println("count:" + count);
    }
}
