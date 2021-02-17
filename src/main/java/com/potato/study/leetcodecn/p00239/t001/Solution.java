package com.potato.study.leetcodecn.p00239.t001;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

  

 示例 1：

 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 输出：[3,3,5,5,6,7]
 解释：
 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 示例 2：

 输入：nums = [1], k = 1
 输出：[1]
 示例 3：

 输入：nums = [1,-1], k = 1
 输出：[1,-1]
 示例 4：

 输入：nums = [9,11], k = 2
 输出：[11]
 示例 5：

 输入：nums = [4,-2], k = 2
 输出：[4]
  

 提示：

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 1 <= k <= nums.length

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 滑动窗口 最大值 使用 双端队列 实现
     * 为什么使用双端队列，因为过程中保证队列优先性需要在两个端进行删除
     * 另外 这个双端队列 也是一个单调队列 队列中的元素 为 nums 数组中的下标，
     * 遍历 nums 中的每个数列 如果队列小于 k 入队 且 保证 如果新的元素 比之前对尾的大，那么一直pop队尾，并最终将这个元素插入队列中
     * 如此 操作之后的对头元素就是 目前这个窗口里边最大的元素
     *
     * 每次新增元素时， 如果需要删除 对头元素 直接操作删除 即可
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列 对头就是 当前窗口 的最大值， 队尾 是 备用最大值，随时可以删除
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            // 如果 新元素比 队尾 大 队尾就没有存在必要了
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            // 删除之前的节点
            if (i >= k && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // 如果 新元素比 队尾 大 队尾就没有存在必要了
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 生成结果
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = solution.maxSlidingWindow(nums, k);
        // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(ints));
    }
}
