package com.potato.study.leetcodecn.p0015.t001;

import com.potato.study.leetcode.util.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

  

 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 使用map 记录 num ： 出现次数
     * 双循环遍历 nums 计算加和，在map中 找到 另一个数字，如果另一个数字与 一个加数字重复，比较是否存在足够的数字
     * 使用map记录当前三元组，key 使用 升序，拼接
     *
     * 时间复杂度 n*n + n
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. 使用map 记录 num ： 出现次数
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            Integer count = numCountMap.getOrDefault(num, 0);
            count++;
            numCountMap.put(num, count);
        }
        // 2. 使用map记录当前三元组，key 使用 升序，拼接
        Map<String, List<Integer>> resultMap = new HashMap<>();
        // 3. 双循环遍历 nums 计算加和，在map中 找到 另一个数字，如果另一个数字与 一个加数字重复，比较是否存在足够的数字
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = -1 * (nums[i] + nums[j]);
                // 完全没有这个数字
                if (!numCountMap.containsKey(target)) {
                    continue;
                }
                // 三个数相等
                if (nums[i] == nums[j] && nums[i] == target) {
                    Integer count = numCountMap.get(target);
                    String key = nums[i] + "," + nums[j] + "," + target;
                    if (count >= 3 && !resultMap.containsKey(key)) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(target);
                        resultMap.put(key, res);
                    }
                } else if (nums[i] == target || nums[j] == target) {
                    Integer count = numCountMap.get(target);
                    if (count >= 2) {
                        addList3ToMapWithKey(resultMap, nums[i], nums[j], target);
                    }
                } else {
                    // 不care 个数List<Integer> res = new ArrayList<>();
                    addList3ToMapWithKey(resultMap, nums[i], nums[j], target);
                }
            }
        }
        List<List<Integer>>  finalResult = new ArrayList<>(resultMap.values());
        return finalResult;
    }

    /**
     * 向 resultMap 中 写入 三个元素组成key的 list
     * @param resultMap
     * @param num
     * @param num1
     * @param target
     */
    private void addList3ToMapWithKey(Map<String, List<Integer>> resultMap, int num, int num1, int target) {
        List<Integer> list = new ArrayList<>();
        list.add(num);
        list.add(num1);
        list.add(target);
        Collections.sort(list);
        String key = list.get(0) + "," + list.get(1) + "," + list.get(2);
        if (!resultMap.containsKey(key)) {
            resultMap.put(key, list);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);

        ListUtil.printListList(lists);

    }


}
