package com.potato.study.leetcode.p0491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         491. Increasing Subsequences
 * 
 *         Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.



Example:

Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]


Note:

The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 * 
 *         思路：
 *         很简单 排序， 然后 遍历 形成序列
 *         https://www.cnblogs.com/apanda009/p/7304914.html
 *
 * 
 */
public class Solution {


    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        helper(res, nums, 0, temp);
        return new ArrayList<>(res);
    }

    /**
     * 递归 生成结果
     * @param res   总结果
     * @param nums  有序
     * @param currentPos     当前要遍历的位置
     * @param temp  缓存结果
     */
    private void helper(Set<List<Integer>> res, int[] nums, int currentPos, List<Integer> temp) {
        // 1. 检查结果
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }
        // 2. 从当前位置开始遍历 nums 如果 nums 大于 temp 那么 将其方到tmp 中 递归遍历 i+ 1 遍历完了 之后 将本次的删除
        for (int i = currentPos; i < nums.length; i++) {
            if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                helper(res, nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }



    public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {4, 3, 2, 1};
		int[] nums = {4, 6, 7, 7};
        List<List<Integer>> list = solution.findSubsequences(nums);
		System.out.println(list);
	}
}
