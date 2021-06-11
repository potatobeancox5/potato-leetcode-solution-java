package com.potato.study.leetcodecn.p00229.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 II
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 nums 计数
     *
     * 遍历计数map  超过 ⌊ n/3 ⌋ 次的元素 记录
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
        }
        List<Integer> list = new ArrayList<>();
        int target = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() > target) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{0,1,2,4,5,7};
//        List<String> list = solution.summaryRanges(nums);
//        System.out.println(list); // ["0->2","4->5","7"]
//
//
//        nums = new int[]{-1};
//        list = solution.summaryRanges(nums);
//        System.out.println(list); // ["-1"]
    }

}
