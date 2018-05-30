package com.potato.study.leetcode.p0120;

import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         120. Triangle
 *         
 *          
 *         Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 *         思路：
 *         计算最小的路径值 代表 走到从0层到i层 需要的最小权值 （不包括i层的值）
 *         power[i][j] = min{power[i-1][j-1] + list[i-1][j-1],power[i-1][j] + list[i-1][j]} 
 *         压缩状态量
 *         记录上层的值 tmp =  power[j]
 *         cur = min{tmp + list[i-1][j-1],power[j] + list[i-1][j]} 
 *          tmp =  power[j]
 *          power[j] = cur
 *         
 *         
 *         
 *         使用power[] 与当前位置的和相加就可以了
 *         
 * 
 */
public class Solution {
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int[] power = new int[triangle.size()];
		for(int i = 0 ; i < triangle.size() ; i++) {
			int tmp = 0;
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0) {
					tmp = power[j];
					power[j] = power[j] + triangle.get(i).get(j);
				} else if(j == i) {
					power[j] = tmp + triangle.get(i).get(j);
				} else {
					  int cur = min(tmp, power[j]) + triangle.get(i).get(j);
					  tmp =  power[j];
					  power[j] = cur;
				}
			}
		}
		//遍历数组计算最小值
		int minValue = Integer.MAX_VALUE;
		for(int i = 0 ; i < power.length ; i++) {
			if(minValue > power[i]) {
				minValue = power[i];
			}
		}
		return minValue;
    }
	
	private int min(int a, int b) {
		return a < b ? a : b;
	}
	
	public static void main(String[] args) {
//		Solution solution = new Solution();
//		List<List<Integer>> triangle = new ArrayList<>();
//		triangle.add(new ArrayList<>().);
//		
//		int min = solution.minimumTotal(triangle);
//		System.out.println(min);
	}
}
