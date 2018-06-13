package com.potato.study.leetcode.p0128;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *        128. Longest Consecutive Sequence
 *         
 *    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 *         
 *         思路：
 *        	dfs的一种变形  每个数是一个节点
 *        最开始将所有的数字放到set中
 *        然后一每个数字为节点 分别向左和向右搜索 记录搜索的节点数 知道中断 
 *        中断时比较当前连续的长度 
 *        搜索每个节点完毕之后 将节点 从set中踢出
 *        最后 返回最长的数量 
 *        	  
 *         https://www.cnblogs.com/ccsccs/articles/4216098.html
 *         
 * 
 */
public class Solution {
	
	
	public int longestConsecutive(int[] nums) {
		int maxConsecutiveLen = 0;
		if(null == nums || nums.length == 0) {
			return maxConsecutiveLen;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		// 以每个数字为节点进行查找
		for (int num : nums) {
			if(set.contains(num)) { // 不存在是因为之前遍历的时候 删掉了
				int len = 1;
				int left = num - 1;
				while(set.contains(left)) {
					set.remove(left);
					len++;
					left--;
				}
				int right = num + 1;
				while(set.contains(right)) {
					set.remove(right);
					len++;
					right++;
				}
				// 判断最大值
				if(maxConsecutiveLen < len) {
					maxConsecutiveLen = len;
				}
			}
		}
		return maxConsecutiveLen;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {100, 4, 200, 1, 3, 2};
		int len = solution.longestConsecutive(nums);
		System.out.println(len);
	}
}
