package com.potato.study.leetcodecn.p00762.t001;

import org.junit.Assert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 762. 二进制表示中质数个计算置位
 *
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。

 （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）

 示例 1:

 输入: L = 6, R = 10
 输出: 4
 解释:
 6 -> 110 (2 个计算置位，2 是质数)
 7 -> 111 (3 个计算置位，3 是质数)
 9 -> 1001 (2 个计算置位，2 是质数)
 10-> 1010 (2 个计算置位，2 是质数)
 示例 2:

 输入: L = 10, R = 15
 输出: 5
 解释:
 10 -> 1010 (2 个计算置位, 2 是质数)
 11 -> 1011 (3 个计算置位, 3 是质数)
 12 -> 1100 (2 个计算置位, 2 是质数)
 13 -> 1101 (3 个计算置位, 3 是质数)
 14 -> 1110 (3 个计算置位, 3 是质数)
 15 -> 1111 (4 个计算置位, 4 不是质数)
 注意:

 L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 R - L 的最大值为 10000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param left
     * @param right
     * @return
     */
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = getPrimeSet();
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bitCount = getBitCount(i);
            if (set.contains(bitCount)) {
                count++;
            }
        }
        return count;
    }

    private Set<Integer> getPrimeSet() {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        set.add(23);
        return set;
    }

    /**
     *
     * @return
     */
    private int getBitCount(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int left = 6;
        int right = 10;
        int i = solution.countPrimeSetBits(left, right);
        System.out.println(i);
        Assert.assertEquals(4, i);


        left = 10;
        right = 15;
        i = solution.countPrimeSetBits(left, right);
        System.out.println(i);
        Assert.assertEquals(5, i);
    }
}
