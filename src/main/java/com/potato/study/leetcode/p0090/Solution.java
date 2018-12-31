package com.potato.study.leetcode.p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         90. Subsets II
 *         
 *         Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * 
 *         思路：
 *         首选对数组排序
 *         对第一个元素 当前位 {}   本次生成{1}  总的列表中具有 {} ，{1} 之前元素 before = index1 记录本次生成列表
 *         对于之后的元素 
 *         	如果 当前元素 与before不同 则 本次将历史 列表 都添加 cur 并添加到历史列表中 记录本次生成列表
 *         	如果 当前元素 == before 则 本次生成为上次生成列表 加上这个元素 更新历史列表 并将更新本次生成列表
 *         https://www.cnblogs.com/ganganloveu/p/4143592.html
 * 			
 */
public class Solution {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>(0));
		if (null == nums || nums.length == 0) {
			return result;
		}
        Arrays.sort(nums);
        List<List<Integer>> currentResult = new ArrayList<>();
        List<Integer> firstNode = new ArrayList<>();
        firstNode.add(nums[0]);
        currentResult.add(firstNode);
        int before = nums[0];
        result.addAll(currentResult);
        for(int i = 1 ; i < nums.length ; i++) { // 遍历数组并生成新的元素
        	if(nums[i] == before) {
        		List<List<Integer>> newCurrentResult = new ArrayList<>();
        		for (List<Integer> list : currentResult) {
					List<Integer> newNode = new ArrayList<>(list);
					newNode.add(nums[i]);
					newCurrentResult.add(newNode);
				}
//        		result.addAll(newCurrentResult);
        		currentResult = newCurrentResult;
        	} else { //不等
        		currentResult.clear();
        		for (List<Integer> list : result) {
					List<Integer> newNode = new ArrayList<>(list);
					newNode.add(nums[i]);
					currentResult.add(newNode);
				}
        	}
        	result.addAll(currentResult);
        	before = nums[i];
        }
        return result;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,2};
		List<List<Integer>> list = solution.subsetsWithDup(nums);
		System.out.println(list);
	}
}
