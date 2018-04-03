package com.potato.study.leetcode.p0077;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *  77. Combinations
 *  
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
] *        
 *  思路：
 *  采用递归
 *  
 *   
 */
public class Solution {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 1 ; i <= n - k + 1; i++ ) {
			List<Integer> temp = new ArrayList<>();
			temp.add(i);
			generateCombine(result, k - 1, i + 1, temp, n);
		}
		return result;
	}
	
	/**
	 * 当k = 0 时，将temp 装到result中
	 * @param result	总的记录
	 * @param k			目前还缺多少个数
	 * @param startNum	目前使用的数字
	 * @param temp		临时结果
	 * @param n 		一共到几号
	 */
	private void generateCombine(List<List<Integer>> result, int k, 
			int startNum, List<Integer> temp, int n) {
		if(k == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i = startNum ; i <= n - k + 1 ; i++) {
			List<Integer> nextTemp = new ArrayList<>();
			nextTemp.addAll(temp);
			nextTemp.add(i);
			generateCombine(result, k - 1, i + 1, nextTemp, n);
		}
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> result = solution.combine(4, 3);
		System.out.println(result);
	}
}
