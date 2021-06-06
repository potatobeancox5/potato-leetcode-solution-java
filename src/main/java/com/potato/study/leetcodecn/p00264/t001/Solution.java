package com.potato.study.leetcodecn.p00264.t001;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II

 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。

 丑数 就是只包含质因数 2、3 和/或 5 的正整数。

  

 示例 1：

 输入：n = 10
 输出：12
 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 示例 2：

 输入：n = 1
 输出：1
 解释：1 通常被视为丑数。
  

 提示：

 1 <= n <= 1690


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ugly-number-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用小根堆 每次 获取堆顶
     * 扩大235倍之后 入堆
     * 用set先去重然后入堆
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> priorityQueue = new PriorityQueue();
        priorityQueue.add(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            Long poll = priorityQueue.poll();
            index++;
            if (index == n) {
                return poll.intValue();
            }
            long[] next = new long[] {
                    2 * poll, 3 * poll, 5 * poll
            };
            for (long num : next) {
                if (!set.contains(num)) {
                    set.add(num);
                    priorityQueue.add(num);
                }
            }
        }
        return -1;
    }




}
