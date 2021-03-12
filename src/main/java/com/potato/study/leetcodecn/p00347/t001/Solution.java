package com.potato.study.leetcodecn.p00347.t001;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

  

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
  

 提示：

 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 你可以按任意顺序返回答案。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 计算出现次数 放到优先级队列中
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.getOrDefault(nums[i], 0);
            count++;
            countMap.put(nums[i], count);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            priorityQueue.add(new int[]{entry.getValue(), entry.getKey()});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int[] poll = priorityQueue.poll();
            result[i] = poll[1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        int[] res = solution.topKFrequent(nums, k);
        // 1,2
        System.out.println(Arrays.toString(res));


        nums = new int[] {1};
        k = 1;
        res = solution.topKFrequent(nums, k);
        // 1,2
        System.out.println(Arrays.toString(res));
    }
}
