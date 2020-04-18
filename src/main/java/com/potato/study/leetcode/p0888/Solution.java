package com.potato.study.leetcode.p0888;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhao11
 *
 *
 * 888. Fair Candy Swap
 *
 *
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.

If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.



Example 1:

Input: A = [1,1], B = [2,2]
Output: [1,2]
Example 2:

Input: A = [1,2], B = [2,3]
Output: [1,2]
Example 3:

Input: A = [2], B = [1,3]
Output: [2,3]
Example 4:

Input: A = [1,2,5], B = [2,4]
Output: [5,4]


Note:

1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
It is guaranteed that Alice and Bob have different total amounts of candy.
It is guaranteed there exists an answer.
 *
 * 题目含义：
 *  两个人 通过交换始的两人的糖果数量相同，返回一个数组 两人分别需要交换的糖果数量
 *
 *  https://www.cnblogs.com/grandyang/p/10896080.html
 *
 */
public class Solution {

    public int[] fairCandySwap(int[] a, int[] b) {
        // 计算a b sum的一半，  遍历 b 找到 b + diff 是不是在 set 中
        long sumA = 0;
        long sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int aa : a) {
            sumA += aa;
            set.add(aa);
        }

        for (int bb : b) {
            sumB += bb;
        }

        long diff = (sumA - sumB) / 2;

        for (int bb : b) {
            if (set.contains((int)(bb + diff))) {
                return new int[]{(int)(bb + diff), bb};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,1};
        int[] b = new int[]{2,2};
        int[] result = solution.fairCandySwap(a, b);
        System.out.println(Arrays.toString(result)); // [1,2]
    }
}
