package com.potato.study.leetcode.p0039;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         39. Combination Sum
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 *         思路：递归
 *         从大向小找 递归找 
 *         
 *         
 * 
 */
public class Solution {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		int times = 0 ;
		getResult(result, current, target, candidates, candidates.length - 1, times);
		return result;
    }
	
	/**
	 * 
	 * @param result		总的结果
	 * @param current		当前已经有的数字
	 * @param target		目标数
	 * @param candidates	在哪个数组中找（升序）
	 * @param index			当前找的节点
	 * @param times			当前数字已经查找的次数
	 */
	private void getResult (List<List<Integer>> result, List<Integer> current, int target, 
			int[] candidates, int index, int times) {
		if(index < 0) {
			return;
		}
		if (target == candidates[index]) {
			List<Integer> simpleResult = new ArrayList<>();
			simpleResult.addAll(current);
			simpleResult.add(candidates[index]);
			result.add(simpleResult);
		} else if(target > candidates[index]) {
			if(times < candidates[index]) {
				List<Integer> newCurrent = new ArrayList<>();
				newCurrent.addAll(current);
				newCurrent.add(candidates[index]);
				getResult (result, newCurrent, target - candidates[index], candidates, index, times++);
			} else {
				getResult (result, current, target - candidates[index], candidates, index - 1, 0);
			}
		} 
		getResult (result, current, target, candidates, index - 1, 0);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = {1 ,2, 3, 4 , 6, 7};
		int target = 7;
		List<List<Integer>> result = solution.combinationSum(candidates, target);
		System.out.println(result);
	}
}
