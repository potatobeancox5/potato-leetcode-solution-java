package com.potato.study.leetcodecn.p01004.t001;

import org.junit.Assert;

/**
 * 1004. 最大连续1的个数 III
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

 返回仅包含 1 的最长（连续）子数组的长度。

  

 示例 1：

 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 输出：6
 解释：
 [1,1,1,0,0,1,1,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 示例 2：

 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 输出：10
 解释：
 [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
  

 提示：

 1 <= A.length <= 20000
 0 <= K <= A.length
 A[i] 为 0 或 1 

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * count [] i  记录 达到i位置 需要翻转多少个 0
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int[] count = new int[nums.length];
        if (nums[0] == 0) {
            count[0]++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[i] = 1 + count[i-1];
            } else {
                count[i] = count[i-1];
            }
        }
        // 两个指针 找到 最大的距离
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < nums.length) {
            if (count[end] <= k) {
                max = Math.max(max, end + 1);
            } else {
                // start 往后移动
                while (start <= end) {
                    if (count[end] - count[start] > k) {
                        start++;
                    } else {
                        break;
                    }
                }
                if (start <= end) {
                    max = Math.max(max, end - start);
                }
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int i = solution.longestOnes(arr, k);
        System.out.println(i);
        Assert.assertEquals(6, i);


        arr = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        k = 3;
        i = solution.longestOnes(arr, k);
        System.out.println(i);
        Assert.assertEquals(10, i);

        arr = new int[]{0,0,0,1};
        k = 4;
        i = solution.longestOnes(arr, k);
        System.out.println(i);
        Assert.assertEquals(4, i);
    }
}
