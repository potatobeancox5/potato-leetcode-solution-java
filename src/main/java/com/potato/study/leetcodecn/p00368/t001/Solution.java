package com.potato.study.leetcodecn.p00368.t001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * 368. 最大整除子集
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    // 368
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // nums 按照 大小从小到大排序
        Arrays.sort(nums);
        // dp i 当前元素 作为最大元素 的最大
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxTime = 1;
        int maxTimeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 大的比小的大
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxTime) {
                maxTime = dp[i];
                maxTimeIndex = i;
            }
        }
        // 记录 转移 从 最大位置开始找
        List<Integer> list = new ArrayList<>();
        list.add(nums[maxTimeIndex]);
        maxTime--;
        for (int i = maxTimeIndex - 1; i >= 0; i--) {
            if (maxTime == dp[i] && nums[maxTimeIndex] % nums[i] == 0) {
                maxTimeIndex = i;
                list.add(nums[i]);
                maxTime--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {
            1,2,3
        };
        List<Integer> list = solution.largestDivisibleSubset(nums);
        System.out.println(list);

        nums = new int[] {
                1,2,4,8
        };
        list = solution.largestDivisibleSubset(nums);
        System.out.println(list);
    }
}
