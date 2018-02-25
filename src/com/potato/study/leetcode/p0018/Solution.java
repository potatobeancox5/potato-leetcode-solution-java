package com.potato.study.leetcode.p0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11 
 * 
 * 		18. 4Sum
 * 
 * 		 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * 
 * 
 * 
 *         思路：给定一个数组 找到 4个元素的和 等于给定的target的所有元组
 *         能想到的办法 与sum3 相同 先 固定一个值i from 0 to length - 4(包含) 
 *         然后从 i+ 1 到length -1 找到 三个数 等于 target - nums[i] O(n^3)
 * 			
 * 		但是 可以优化到O(n^2)
 *  		   先计算出来，任意两个数的sum  组 O(n^2) 并纪录 参与计算的两个数的index 
 *  		   然后计算，nums 中 除了 给定的两个数 是否存在 等于target - sum的另外两个数的值
 * 		
 * 
 */
public class Solution {
	
	/**
	 * 复用3sum 的逻辑
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		// 从 nums 0 开始 知道 nums.length - 4(包含)
		for(int i = 0 ; i < nums.length - 3 ; i++) {
			if(i != 0 && nums[i] == nums[i-1]) { // 去除重复
				continue;
			}
			List<List<Integer>> list = threeSum(nums, target, i + 1, nums[i]);
			if(!list.isEmpty()) {
				result.addAll(list);
			}
		}
		return result;
    }
	
	
	/**
	 * 计算三个数的和
	 * @param nums			目标数组
	 * @param targetSum		最终和
	 * @param start			开始元素index
	 * @param current		之前选择的元素的值
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums, int targetSum , int start , int current) {
		int target = targetSum - current;
		List<List<Integer>> result = new ArrayList<>();
		if(null == nums || nums.length - start < 3) {
			return result;
		}
		for(int i = start ; i < nums.length ; i++) { // 设置目标
			if(i != start && nums[i] == nums[i-1]) {
				continue;
			}
			//int target = nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				// 判断 left 值有没有变化
				if(left != i + 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				int tmp = nums[left] + nums[right];
				if(tmp + nums[i] == target) { // 找到
					List<Integer> singleResult = new ArrayList<>(4);
					singleResult.add(current);
					singleResult.add(nums[i]);
					singleResult.add(nums[left]);
					singleResult.add(nums[right]);
					result.add(singleResult);
					left++;
					right--;
				} else if(tmp + nums[i] < target) {
					left++;
				} else { // tmp > target
					right--;
				}
			}
		}
        return result;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>>  list = solution.fourSum(nums, target);
		System.out.println(list);
	}

}
