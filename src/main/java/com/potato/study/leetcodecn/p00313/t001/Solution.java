package com.potato.study.leetcodecn.p00313.t001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Assert;

/**
 * 313. 超级丑数
 *
 * 编写一段程序来查找第 n 个超级丑数。
 *
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 *
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 *
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 小根堆 每次 出最小的 都 一遍乘以 入队
     * set 去重
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1L);
        Set<Long> hasAppearSet = new HashSet<>();
        hasAppearSet.add(1L);
        for (int i = 0; i < n-1; i++) {
            Long poll = priorityQueue.poll();
            for (int prime : primes) {
                long target = poll * prime;
                if (!hasAppearSet.contains(target)) {
                    hasAppearSet.add(target);
                    priorityQueue.add(target);
                }
            }
        }
        return priorityQueue.peek().intValue();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        int[] primes = new int[]{
                2,7,13,19
        };
        int s = solution.nthSuperUglyNumber(n, primes);
        System.out.println(s);
        Assert.assertEquals(32, s);

        n = 100000;
        primes = new int[]{
                7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251
        };
        s = solution.nthSuperUglyNumber(n, primes);
        System.out.println(s);
        Assert.assertEquals(1092889481, s);



    }
}
