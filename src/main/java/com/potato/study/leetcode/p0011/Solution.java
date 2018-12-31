package com.potato.study.leetcode.p0011;

/**
 * 
 * @author liuzhao11
 * 
 *         11. Container With Most Water
 * 
 *         Given n non-negative integers a1, a2, ..., an, where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 *         which together with x-axis forms a container, such that the container
 *         contains the most water.
 * 
 *         Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 *         思路：
 *         从两次开始left right 逐渐相内部移动
 *         每次移动左边和右边中高度小的那个 ，移动之后计算当前最大的容量 并记下最大容量
 * 				
 * 
 */
public class Solution {
	
	public int maxArea(int[] height) {
        if (null == height || height.length == 0) {
			return 0;
		}
        int left = 0 ;
        int right = height.length - 1;
        int maxArea = Math.min(height[left], height[right]) * (right - left);
        while(left < right) {
        		maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
        		if(height[left] > height[right]) {
        			right--;
        		} else {
        			left++;
        		}
        }
        return maxArea;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] height = {1,2,3,4,5,6};
		int area = solution.maxArea(height);
		System.out.println("area:" + area);
	}

}
