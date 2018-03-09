package com.potato.study.leetcode.p0042;

/**
 * 
 * @author liuzhao11
 * 
 *        42. Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 *         思路：
 *         分别扫描左右 找到边缘 上升的极值点
 *         while（左边< 右边）
 *         	如果当前左边小于等于右边
 *         		从左边开始 碰到小于等于它的 计算面积 否则将 左边界置为新位置
 *         	左边大于右边
 *         		从右边开始 碰到小于等于它的 计算面积 否则将 右边界置为新位置
 *        
 * 
 */
public class Solution {
	
	public int trap(int[] height) {
        if(null == height || height.length <=2) {
        	return 0;
        }
        int sum = 0;
        int leftEdge = 0;
        int rightEdge = height.length - 1;
        // 分别扫描左右 找到边缘 上升的极值点
        while(leftEdge < rightEdge && height[leftEdge] < height[leftEdge + 1]) {
        	leftEdge++;
        }
        while(leftEdge < rightEdge && height[rightEdge -1 ] > height[rightEdge]) {
        	rightEdge--;
        }
        while(leftEdge < rightEdge) {
        	int leftHeight = height[leftEdge];
        	int rightHeight = height[rightEdge];
        	if(leftHeight <= rightHeight) {
        		while(leftEdge < rightEdge) {
        			if(leftHeight >= height[leftEdge + 1]) {
        				sum += (leftHeight - height[leftEdge + 1]);
        				leftEdge++;
        			} else {
        				leftEdge++;
        				break;
        			}
        		}
        	} else {
        		while(leftEdge < rightEdge) {
        			if(height[rightEdge - 1] <= rightHeight) {
        				sum += (rightHeight - height[rightEdge - 1]);
        				rightEdge--;
        			} else {
        				rightEdge--;
        				break;
        			}
        		}
        	}
        }
        return sum;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int sum = solution.trap(height);
		System.out.println(sum);
	}
}
