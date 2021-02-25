package com.potato.study.leetcodecn.p01619.t001;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1619. 删除某些元素后的数组均值
 *
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。

 与 标准答案 误差在 10-5 的结果都被视为正确结果。

  

 示例 1：

 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 输出：2.00000
 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 示例 2：

 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 输出：4.00000
 示例 3：

 输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 输出：4.77778
 示例 4：

 输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
 输出：5.27778
 示例 5：

 输入：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
 输出：5.29167
  

 提示：

 20 <= arr.length <= 1000
 arr.length 是 20 的 倍数 
 0 <= arr[i] <= 105

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/mean-of-array-after-removing-some-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计算 5% 数字多少 以此作为 一个 优先队列 大根堆 小根堆
     * 大于 小根堆 进栈
     * 小于 大根堆 出栈
     * 同时 求和
     * 分别减去 两个堆的值 求平均数
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        // 小根堆 最大值
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        // 大根堆 最小值
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int len = arr.length / 20;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (priorityQueue1.size() < len) {
                priorityQueue1.add(arr[i]);
            } else if (priorityQueue1.peek() < arr[i]) {
                priorityQueue1.add(arr[i]);
            }
            if (priorityQueue2.size() < len) {
                priorityQueue2.add(arr[i]);
            } else if (priorityQueue2.peek() > arr[i]) {
                priorityQueue2.add(arr[i]);
            }
            // 超过 len pop
            if (priorityQueue1.size() > len) {
                priorityQueue1.poll();
            }
            if (priorityQueue2.size() > len) {
                priorityQueue2.poll();
            }
        }
        int sum1 = 0;
        while (!priorityQueue1.isEmpty()) {
            sum1 += priorityQueue1.poll();
        }
        int sum2 = 0;
        while (!priorityQueue2.isEmpty()) {
            sum2 += priorityQueue2.poll();
        }
        return (1.0 * sum - sum1 - sum2) / (1.0 * arr.length - len - len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        double v = solution.trimMean(arr);
        System.out.println(v);


        arr = new int[] {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        v = solution.trimMean(arr);
        System.out.println(v);
    }
}
