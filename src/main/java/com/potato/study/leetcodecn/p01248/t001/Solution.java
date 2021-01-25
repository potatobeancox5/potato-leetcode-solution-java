package com.potato.study.leetcodecn.p01248.t001;


import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 *
 * 给你一个整数数组 nums 和一个整数 k。

 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

 请返回这个数组中「优美子数组」的数目。

  

 示例 1：

 输入：nums = [1,1,2,1,1], k = 3
 输出：2
 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 示例 2：

 输入：nums = [2,4,6], k = 1
 输出：0
 解释：数列中不包含任何奇数，所以不存在优美子数组。
 示例 3：

 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 输出：16
  

 提示：

 1 <= nums.length <= 50000
 1 <= nums[i] <= 10^5
 1 <= k <= nums.length

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 前缀和思想，注意 空集前缀处理
     * int oddCount 表示 位置i include 之前有多少个奇数
     * Map int int key标识有k个奇数， value是有k个奇数的前缀数量， 空子集表示有0个奇数
     * 遍历 nums 对于每个位置生成 当前的odd
     *  对于当前的odd - 之前odd == k
     *  计算之前的odd ，从map中取次数并累加到结果里
     *  更新map
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        int oddCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        // 空子集表示有0个奇数 拥有0个奇数的有1中情况 —— 空子集
        countMap.put(0, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                oddCount++;
            }
            // 计算之前的odd ，从map中取次数并累加到结果里
            int target = oddCount - k;
            Integer count = countMap.getOrDefault(target, 0);
            result += count;
            // 更新map
            Integer updateCount = countMap.getOrDefault(oddCount, 0);
            updateCount++;
            countMap.put(oddCount, updateCount);
        }
        return result;
    }
}
