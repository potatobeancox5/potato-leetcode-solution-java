package com.potato.study.leetcode.p0033;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array. unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * 
 *         思路：
 *         给定数组以 某个数轴为中心旋转了 查找给定值 
 *         找到返回 index 否则 返回-1
 *         给定的数组没有重复的
 *         可以用二分法 总有一端是正常的升序 如果 数字不落在这短 那就一定在另外 一侧 在继续使用二分 即可 
 *         
 * 
 */
public class Solution {

	public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0) {
        		return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
        		int mid = (left + right) / 2;
        		// 判断当前数列是否还是逆序的 或者已经好了
        		if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
        			if(target < nums[mid]) {
        				right = mid - 1;
        			} else if (target > nums[mid]) {
        				left = mid + 1;
        			} else {
        				return mid;
        			}
        		} else { // 还是存在逆序的
        			if(nums[mid] == target) { // find
            			return mid;
            		} 
        			// 逆序在哪一侧
        			if(nums[left] > nums[mid]) { //逆序在左边
        				if(target > nums[mid] && target <= nums[right]) { //target zai right
        					left = mid + 1;
        				} else { // target zai left
        					right = mid -1;
        				}
        			} else { // 逆序在右边
        				if(target >= nums[left] && target < nums[mid]) { //target zai zuo
        					right = mid - 1;
        				} else {// target zai right
        					left = mid + 1;
        				}
        			}
        		}
        }
        // left == right   值 == target时
        if (nums[left] == target) {
			return left;
		}
        return -1;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {4,5,6,7,8,1,2,3};
		int target = 8;
		int index = solution.search(nums, target);
		System.out.println(index);

	}
}
