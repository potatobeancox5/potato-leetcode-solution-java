package com.potato.study.leetcodecn.p00300.t001;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

  
 示例 1：

 输入：nums = [10,9,2,5,3,7,101,18]
 输出：4
 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 示例 2：

 输入：nums = [0,1,0,3,2,3]
 输出：4
 示例 3：

 输入：nums = [7,7,7,7,7,7,7]
 输出：1
  

 提示：

 1 <= nums.length <= 2500
 -104 <= nums[i] <= 104
  

 进阶：

 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 你能将算法的时间复杂度降低到 O(n log(n)) 吗?

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp i 记录 从 0 - i 以i结尾的子序列 做多有多少个字符
     * dp i = max { k[0, i-1], 当 i位置数字，大于 k位置数字}
     * 遍历 0 - i-1 时， 从头开始 找最大的一个数字
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] maxSubLength = new int[nums.length];
        // from 0 to 0
        maxSubLength[0] = 1;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 先按照 子序列数量倒序排列
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                // 再按照 子序列 的 数字 升序
                return o1[0] - o2[0];
            }
        });
        priorityQueue.add(new int[]{0, 1});
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            maxSubLength[i] = 1;
            // 遍历 i-1 之前的结果 从大到小
            PriorityQueue<int[]> temp = new PriorityQueue<>(priorityQueue);
            while (!temp.isEmpty()) {
                int[] poll = temp.poll();
                if (nums[poll[0]] >= target) {
                    continue;
                }
                // 小于等于
                maxSubLength[i] = Math.max(maxSubLength[i], 1 + poll[1]);
                break;
            }
            priorityQueue.add(new int[]{i, maxSubLength[i]});
            max = Math.max(max, maxSubLength[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        int num = solution.lengthOfLIS(nums);
        System.out.println(num);
        Assert.assertEquals(4, num);

        nums = new int[] {0,1,0,3,2,3};
        num = solution.lengthOfLIS(nums);
        System.out.println(num);
        Assert.assertEquals(4, num);

        nums = new int[] {7,7,7,7,7,7,7};
        num = solution.lengthOfLIS(nums);
        System.out.println(num);
        Assert.assertEquals(1, num);


        nums = new int[] {1,3,6,7,9,4,10,5,6};
        num = solution.lengthOfLIS(nums);
        System.out.println(num);
        Assert.assertEquals(6, num);
    }
}
