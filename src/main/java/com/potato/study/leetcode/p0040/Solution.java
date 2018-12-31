package com.potato.study.leetcode.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author liuzhao11
 * 
 *         40. Combination Sum II
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 *         思路：递归 与39的区别是 不能重复
 *         从大向小找 递归找 
 *         
 *         
 * 
 */
public class Solution {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		Arrays.sort(candidates);
		for(int i = candidates.length - 1 ; i >= 0 ; i--) {
			if(i < candidates.length - 1 && candidates[i] == candidates[i+1]) {
				continue;
			}
			if(candidates[i] <= target ) {				
				getResult(result, current, target, candidates, i);
			}
		}
		return result;
    }
	
	/**
	 * 必须选择这个数 
	 * @param result		总的结果
	 * @param current		当前已经有的数字
	 * @param target		目标数
	 * @param candidates	在哪个数组中找（升序）
	 * @param index			当前找的节点
	 * @param times			当前数字已经查找的次数
	 */
	private void getResult (List<List<Integer>> result, List<Integer> current, int target, 
			int[] candidates, int index) {
		if(index < 0) {
			return;
		}
		if (target == candidates[index]) {
			List<Integer> simpleResult = new ArrayList<>();
			simpleResult.addAll(current);
			simpleResult.add(candidates[index]);
			result.add(simpleResult);
		} else if(target > candidates[index]) {
			List<Integer> newCurrent = new ArrayList<>();
			newCurrent.addAll(current);
			newCurrent.add(candidates[index]);
			for(int i = index - 1 ; i >=0 ; i--) {
				// 去重
				if(i < index - 1  && candidates[i] != candidates[i + 1]) {					
					getResult (result, newCurrent, target - candidates[index], candidates, i);		
				}else if(i == index - 1) {
					getResult (result, newCurrent, target - candidates[index], candidates, i);
				}
			}
		} 
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = {1 ,2, 3, 4 , 6, 7};
		int target = 7;
		List<List<Integer>> result = solution.combinationSum2(candidates, target);
		System.out.println(result);
	}
}
