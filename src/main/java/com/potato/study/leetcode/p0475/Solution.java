package com.potato.study.leetcode.p0475;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         475. Heaters
 * 
 *        Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:

Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.


Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.


Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 * 
 *         思路：
 *         
 * 
 */
public class Solution {

	public int findRadius(int[] houses, int[] heaters) {
		// 排序
		Arrays.sort(houses);
		Arrays.sort(heaters);
		// 遍历 每个house 和 heaters 找到第一个 大于house的 heater 计算最短的distance

		int minDistance = 0;

		int j = 0;
		for (int i = 0; i < houses.length; i++) {
			while (heaters[j] < houses[i] && j < heaters.length - 1) {
				j++;
			}
			// 判断最最短距离
			if (j == 0) {
				int currentDistance = Math.abs(heaters[j] - houses[i]);
				if (minDistance < currentDistance) {
					minDistance = currentDistance;
				}
			} else if (heaters[j-1] <= houses[i]  && houses[i] <= heaters[j]) {
				int currentDistance = Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]);
				if (minDistance < currentDistance) {
					minDistance = currentDistance;
				}
			} else if (j == heaters.length - 1) {
				int currentDistance = Math.abs(heaters[j] - houses[i]);
				if (minDistance < currentDistance) {
					minDistance = currentDistance;
				}
			}
		}
		return minDistance;
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] houses = {1,2,3};
//		int[] heaters = {2};
//		int[] houses = {1,2,3,4};
//		int[] heaters = {1,4};

		int[] houses = {1,5};
		int[] heaters = {2};

		int radius = solution.findRadius(houses, heaters);

		System.out.println(radius);

	}
}
