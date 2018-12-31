package com.potato.study.leetcode.p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11 
 * 15. 3Sum 
 * 
 * 		Given an array S of n integers, are there elements
 *         a, b, c in S such that a + b + c = 0? Find all unique triplets in the
 *         array which gives the sum of zero.
 *         Note: The solution set must not contain duplicate triplets.
 *         For example, given array S = [-1, 0, 1, 2, -1, -4],
 *         A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 *         思路：
 *         排序数组
 *         从左边选择第一个与之前不一样的数i  target = 0 - nums[i];‘
 *         分别设置左右两个index  left = i+1  right = length - 1; 使用二分法进行查找
 *         		找到就记下结果 这次也要找完 
 *         		没找到就 不要找了 
 *         				
 */
public class Solution {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(null == nums || nums.length < 3) {
			return result;
		}
		// 数组排序成升序
		Arrays.sort(nums);
		for(int i = 0 ; i < nums.length ; i++) { // 设置目标
			if(i != 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int target = nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				// 判断 left 值有没有变化
				if(left != i + 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				int tmp = nums[left] + nums[right];
				if(tmp + target == 0) { // 找到
					List<Integer> singleResult = new ArrayList<>(3);
					singleResult.add(nums[i]);
					singleResult.add(nums[left]);
					singleResult.add(nums[right]);
					result.add(singleResult);
					left++;
					right--;
				} else if(tmp + target < 0) {
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
//		int[] nums = {-1,1,0};
		int[] nums = {-2,0,0,2,2};
		List<List<Integer>> result = solution.threeSum(nums);
		for (List<Integer> list : result) {
			System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2));
		}
	}

}
