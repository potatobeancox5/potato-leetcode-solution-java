package com.potato.study.leetcode.p0078;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *   
 *  思路：
 *  采用递归
 *  
 *   
 */
public class Solution {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());// 先加入一个空集合
        if(nums == null || nums.length == 0) {
        	return result;
        }
        for(int i = 0 ; i < nums.length ; i++) {
        	List<Integer> tmpResult = new ArrayList<>();
        	tmpResult.add(nums[i]);
        	result.add(tmpResult);
        	generateSubsets(nums, i + 1, tmpResult, result);
        } 
        return result;
    }
	
	
	/**
	 * 
	 * @param nums				原始数组
	 * @param currentIndex		当前应该使用的index
	 * @param tmpResult			中间结果
	 * @param result			最终结果
	 */
	private void generateSubsets(int[] nums, int currentIndex, 
			List<Integer> tmpResult, List<List<Integer>> result) {
		if(currentIndex >= nums.length) {
			return;
		}
		for(int i = currentIndex ; i < nums.length ; i++) {			
			List<Integer> tmp = new ArrayList<>();
			tmp.addAll(tmpResult);
			tmp.add(nums[i]);
			result.add(tmp);
			generateSubsets(nums, i + 1, tmp, result);
		}
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3};
		List<List<Integer>> result = solution.subsets(nums);
		System.out.println(result);
	}
}
