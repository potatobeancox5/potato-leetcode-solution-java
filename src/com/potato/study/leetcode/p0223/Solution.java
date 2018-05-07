package com.potato.study.leetcode.p0223;

/**
 * 
 * @author liuzhao11
 * 
 *      223. Rectangle Area
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: -3, 0, 3, 4, 0, -1, 9, 2
Output: 45
Note:
Assume that the total area is never beyond the maximum possible value of int.	
 * *         
 * 思路： 
 *  画一个相交的图 画一个相离的图 就能看出来 下面的比较关系
 *  参考blog
 *  https://blog.csdn.net/DERRANTCM/article/details/48084065
 */
public class Solution {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long lon = max((long)min(C, G) - max(A, E), 0);
        long height = max((long)min(D, H) - max(B, F), 0);
		
        long bothArea = lon * height;
        long area = (C - A) * (D - B) + (G - E) * (H - F);
		return (int)(area - bothArea);
    }
	
	private long max(long a, long b) {
		return a > b ? a : b;
	}
	
	private long min(long a, long b) {
		return a < b ? a : b;
	}
	
	
	
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int area = solution.computeArea(-2, -2, 2, 2, -3, -3, 3, -1);
		System.out.println(area);
	}
}
