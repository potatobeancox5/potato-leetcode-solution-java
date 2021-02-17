package com.potato.study.leetcodecn.p00480.t001;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 480. 滑动窗口中位数
 *
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。

 例如：

 [2,3,4]，中位数是 3
 [2,3]，中位数是 (2 + 3) / 2 = 2.5
 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。

  

 示例：

 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。

 窗口位置                      中位数
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7      -1
 1  3 [-1  -3  5] 3  6  7      -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。

  

 提示：

 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sliding-window-median
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 滑动窗口 返回 中位数
     * 中位数 两个 堆 对着
     * 定义 小根堆p1 和大根堆 p2
     * 要求 p1 不能比 p2 小
     * 对于一个新元素 先进左边 洗一下 再去右边 洗一遍，最后拿到元素用来平衡
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 小根堆 存放 k/2 个元素 如果 多的话 存 奇数个元素 多一下
        PriorityQueue<Long> priorityQueue1 = new PriorityQueue<>();
        // 大根堆，存放 k/2 个元素
        PriorityQueue<Long> priorityQueue2 = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o2, o1);
            }
        });
        // 先将 k 个元素 放入 priorityQueue1， 并调整一半的元素 到 priorityQueue2
        for (int i = 0; i < k; i++) {
            priorityQueue1.add((long)nums[i]);
        }
        boolean isOdd = (k % 2 == 1);
        int len1 = k / 2;
        if (isOdd) {
            len1++;
        }
        // 调整 priorityQueue1
        while (priorityQueue1.size() > len1) {
            priorityQueue2.add(priorityQueue1.poll());
        }
        // 计算 第 k 个元素 对应的中位数 结果
        double[] res = new double[nums.length - k + 1];
        if (isOdd) {
            res[0] = priorityQueue1.peek();
        } else {
            res[0] = (1.0 * priorityQueue1.peek() + priorityQueue2.peek()) / 2;
        }
        // 遍历 k + 1 到 末尾，每个元素重复 之前的步骤， 生成结果 放入res 中
        for (int i = k; i < nums.length; i++) {
            // priorityQueue1 和 priorityQueue2 移除 nums i - k
            if (priorityQueue1.contains((long)nums[i-k])) {
                priorityQueue1.remove((long)nums[i-k]);
            } else {
                priorityQueue2.remove((long)nums[i-k]);
            }
            // priorityQueue1 和 priorityQueue2 调整
            priorityQueue1.add((long)nums[i]);
            while (!priorityQueue1.isEmpty() && !priorityQueue2.isEmpty()
                    && priorityQueue1.peek() < priorityQueue2.peek()) {
                Long temp = priorityQueue1.poll();
                priorityQueue2.add(temp);
            }
            // 调整 个数
            while (priorityQueue1.size() != len1) {
                if (priorityQueue1.size() < len1) {
                    priorityQueue1.add(priorityQueue2.poll());
                } else {
                    priorityQueue2.add(priorityQueue1.poll());
                }
            }
            // 计算 当前结果
            if (isOdd) {
                res[i- k + 1] = priorityQueue1.peek();
            } else {
                res[i- k + 1] = (1.0 * priorityQueue1.peek() + priorityQueue2.peek()) / 2;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] doubles = solution.medianSlidingWindow(nums, k);
//        [1,-1,-1,3,5,6]。
        System.out.println(Arrays.toString(doubles));

        nums = new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,
                2147483647,2147483647,-2147483648,2147483647,-2147483648};
        k = 3;
        doubles = solution.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(doubles));
    }

}
