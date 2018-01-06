package com.potato.study.leetcode.p0118;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.util.ArrayUtil;

/**
 * 
 * @author liuzhao11
 * 118. Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 *		For example, given numRows = 5,
 *		Return		
 *		[
 *		     [1],
 *		    [1,1],
 *		   [1,2,1],
 *		  [1,3,3,1],
 *		 [1,4,6,4,1]
 *		]
 * 
 * 		思路： 第一行  设置 1
 * 			 第二行 开始 从0 到 行号（从0开始）   index = 0  || index = 行号 1
 * 					其他位置    等于 当前上一行的 index - 1  + index 的值 
 */
public class Solution {
	
	public List<List<Integer>> generate(int numRows) {
		if(numRows <= 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		//设置第0行
		List<Integer> line0 = new ArrayList<>();
		line0.add(1);
		result.add(line0);
		for(int i = 1 ; i < numRows ; i++) { // 行号
			List<Integer> thisLine = new ArrayList<>();
			for(int j = 0 ; j <= i ; j++) { //列号
				if(j == 0 || j == i) {
					thisLine.add(1);
				} else {
					thisLine.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			result.add(thisLine);
		}
		return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> result = solution.generate(5);
		ArrayUtil.printListList(result);
	}
}
