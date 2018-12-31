package com.potato.study.leetcode.p0081;

/**
 * 
 * @author liuzhao11
 * 
 * 81. Search in Rotated Sorted Array II
 * 
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
 *   
 *  思路：
 *  	
 *  	已知 left = 0 right = len - 1 
 *  	while left 《  right 时  
 *  	求出 中间的middle = （left+right ） / 2 
 *  	
 *      通过使用mid 判断 那一侧是顺序的 另外一侧就是 反转的 规则是 
 *      		如果 left 《 mid 或者 mid 》 right  那么左边是顺序的    情况1
 *  			如果 mid 《 right 或者 left 》 mid  那么右边是顺序的 情况2
 *  			 如果前两种情况都没确定哪个是顺序的的 就是情况3 只有一种可能出现情况三 left == mid == right 
 *  			对于情况1 2 来说
 *  				如果left mid 与target 相等 返回 true  
 *  				判断    target 是否在顺序侧中间，是的话 重置left right 继续查找
 *  			对于情况3 
 *   				直接遍历吧 妈的
 *   	判断 left 与 right 相等情况
 *   	此时 找到 target 返回true 否则 返回false
 */
public class Solution {
	
	public boolean search(int[] nums, int target) {
		if (null == nums || nums.length == 0) {
			return false;
		}
		int left = 0;
		int right = nums.length - 1;
//		已知 left = 0 right = len - 1 
		while(left < right) {
			if(nums[left] == target || nums[right] == target) {
				return true;
			}
			int middle = (left + right) / 2;
			if(nums[middle] == target) {
				return true;
			}
			boolean foundSequence = false;
			int sequenceLeft = 0;
			int sequenceRight = 0;
			int notSequenceLeft = 0;
			int notSequenceRight = 0;
			//判断那一侧是顺序的那一侧
			if(nums[left] < nums[middle] || nums[middle] > nums[right]) { // 左侧是顺序侧
				foundSequence = true; 
				sequenceLeft = left;
				sequenceRight = middle - 1;
				notSequenceLeft = middle + 1;
				notSequenceRight = right;
			} else if (nums[middle] <  nums[right] || nums[left] > nums[middle]) { // 右侧是顺序侧
				foundSequence = true;
				sequenceLeft = middle + 1;
				sequenceRight = right;
				notSequenceLeft = left;
				notSequenceRight = middle - 1;
			} else { //left == mid == right 
				for(int i = left ; i < right ; i++) {
					if(nums[i] == target) {
						return true;
					}
				}
				return false;
			}
			if(foundSequence) { // 找到顺序侧 在顺序侧对进行判断 没有找到的情况之前已经处理过了
				if(sequenceLeft <= sequenceRight) {					
					if(nums[sequenceLeft] == target || nums[sequenceRight] == target) {
						return true;
					}
					//判断该值是否在顺序侧
					if(nums[sequenceLeft] < target && target < nums[sequenceRight]) {
						left = sequenceLeft;
						right = sequenceRight;
					} else {
						left = notSequenceLeft;
						right = notSequenceRight;
					}
				} else {
					left = notSequenceLeft;
					right = notSequenceRight;
				}
			}
		}
		if(left == right && nums[left] == target) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {10,10,10,-10,-10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,9,9,9,9,9,10,10};
		int target = 10;
//		int[] nums = {1};
//		int target = 1;
		boolean result = solution.search(nums, target);
		System.out.println(result);
		
	}
}
