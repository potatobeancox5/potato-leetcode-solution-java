package com.potato.study.leetcode.p0857;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	857. Minimum Cost to Hire K Workers
 *  
 *         There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.



Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.


Note:

1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers/solution/gu-yong-k-ming-gong-ren-de-zui-di-cheng-ben-by-lee/
 *         堆（优先队列）
 *
 *
 *
 */
public class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int num = quality.length;
        // 生成 worker
        Worker[] workers = new Worker[num];
        for (int i = 0; i < num; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        // 按照 ratio 升序排序
        Arrays.sort(workers);
        // 使用 小根堆 维护一个  -quality quality(大根堆)
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 遍历 workers sumq 计算总 quality
        int sumQualidy = 0;
        double res = Double.MAX_VALUE;
        for (Worker worker : workers) {
            heap.add(worker.quality);
            // 用于直接计算结果
            sumQualidy += worker.quality;
            if (heap.size() > k) {
                sumQualidy -= heap.poll();
            }

            if (heap.size() == k) {
                res = Math.min(res, sumQualidy * worker.ratio);
            }

        }
        return res;
    }

    class Worker implements Comparable<Worker>{
        public int quality;
        public int wage;
        // wage / quality;
        public double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double)wage / quality;
        }

        @Override
        public int compareTo(Worker o) {
            return Double.compare(ratio, o.ratio);
        }
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] quality = new int[]{10,20,5};
        int[] wage = new int[]{70,50,30};
        int k = 2;
        double result = solution.mincostToHireWorkers(quality, wage, k);
        System.out.println(result); // 105.00000


        quality = new int[]{3,1,10,10,1};
        wage = new int[]{4,8,2,2,7};
        k = 3;
        result = solution.mincostToHireWorkers(quality, wage, k);
        System.out.println(result); // 30.66667
    }
}
