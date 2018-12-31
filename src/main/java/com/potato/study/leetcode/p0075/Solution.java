package com.potato.study.leetcode.p0075;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         
 *         75. Sort Colors
 *         
 *       Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?  
 * 			
 *  思路：
 *  要求只遍历一次数组，然后就能得到结果
 *  考虑到排序后的结果0都在最前边 2都在最后边 
 *  这样设置两个指针 指向左边第一个不是0的位置zeroIndex 和右边第一个不是2的位置 twoIndex
 *  然后从zeroIndex 开始查找第一个为0 或者 2 的数 与指定位置交换
 *  		若交换的是0的时候 则 zeroIndex 向后移动一个位置
 *  		若交换的是2的时候 则twoIndex 向前找第一个不为2的位置
 *  终止条件是当前index 》 twoIndex
 *   
 */
public class Solution {

	public void sortColors(int[] nums) {
        int zeroIndex = 0;
        while(zeroIndex  < nums.length && nums[zeroIndex] == 0) {
        	zeroIndex++;
        }
        int twoIndex = nums.length - 1;
        while(twoIndex >= 0 && nums[twoIndex] == 2) {
        	twoIndex--;
        }
        int index = zeroIndex;
        while(index <= twoIndex) {
        	if(nums[index] == 0) {
        		nums[index] = nums[zeroIndex];
        		nums[zeroIndex] = 0; 
        		while(zeroIndex  < nums.length && nums[zeroIndex] == 0) {
                	zeroIndex++;
                }
        		index = zeroIndex;
        	} else if(nums[index] == 2) {
        		nums[index] = nums[twoIndex];
        		nums[twoIndex] = 2;
        		while(twoIndex >= 0 && nums[twoIndex] == 2) {
        			twoIndex--;
        	    }
        	} else { //nums[index] == 1
        		index++;
        	}
        }
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {1,0,0,1,1,1,2,0,2};
		int[] nums = {2,0,0};
		solution.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
