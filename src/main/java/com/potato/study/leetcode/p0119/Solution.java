package com.potato.study.leetcode.p0119;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.util.ListUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         119. Pascal's Triangle II 
 *         Given an index k, return the kth row of the
 *         Pascal's triangle.
 * 
 *         For example, given k = 3, Return [1,3,3,1].
 * 
 *         Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 *         思路：
 *         和118 相似 只是 开一个数组记录之前的行 开一个数组记录目前的值
 */
public class Solution {
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> beforeLine = new ArrayList<>();
		if (rowIndex < 0) {
			return beforeLine;	
		}
		beforeLine.add(1);
		if(rowIndex == 0) {
			return beforeLine;
		}
        for(int i = 1 ; i <= rowIndex ; i++) {
        	List<Integer> currentLine = new ArrayList<>();
        	for(int j = 0 ; j <= i; j++) {
        		if (j == 0 || j == i) {
					currentLine.add(1);
				} else {
					currentLine.add(beforeLine.get(j -1) + beforeLine.get(j));
				}
        	}
        	beforeLine = currentLine;
        }
        return beforeLine;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> result = solution.getRow(3);
		ListUtil.printList(result);
	}
}
