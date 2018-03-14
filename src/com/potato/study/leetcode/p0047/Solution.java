package com.potato.study.leetcode.p0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *        47. Permutations II
 * 
 * 		Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 *         思路：求一个数排列的全排列
 *         给数组排序
 *         设定一个visit数组 记录当次那几个数字已经被选择过
 *         
 * 
 * 
 */
public class Solution {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		generatePermute(result, visited, new ArrayList<>(), nums);
		return result;
	}
	
	/**
	 * 
	 * @param result		最终结果
	 * @param visited		当前轮次访问过的位置
	 * @param current		当前已经访问得结果
	 * @param nums			目标数组
	 */
	private void generatePermute(List<List<Integer>> result, boolean[] visited, 
			List<Integer> current, int[] nums) {
		if(current.size() == nums.length) {
			result.add(new ArrayList<>(current));
		}
		// 遍历数组 加上当前没有访问的元素
		for(int i = 0 ; i < nums.length ; i++) {
			if(i > 0 && !visited[i-1] && nums[i] == nums[i-1]) { // 没有访问时 必须保障前一个为访问的数组和自己不一样 前提相同的数字总是前面一个先进入队列
				continue;
			} else if(!visited[i]) {
				current.add(nums[i]);
				visited[i] = true;
				generatePermute(result, visited, current, nums);
				current.remove(current.size() - 1);
				visited[i] = false;
			} 
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,1,2};
		List<List<Integer>> list = solution.permuteUnique(nums);
		System.out.println(list);
		
	}
}
