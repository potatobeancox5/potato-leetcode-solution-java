package com.potato.study.leetcode.p0492;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         492. Construct the Rectangle
 * 
 *         For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

1. The area of the rectangular web page you designed must equal to the given target area.

2. The width W should not be larger than the length L, which means L >= W.

3. The difference between length L and width W should be as small as possible.
You need to output the length L and the width W of the web page you designed in sequence.
Example:
Input: 4
Output: [2, 2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
Note:
The given area won't exceed 10,000,000 and is a positive integer
The web page's width and length you designed must be positive integers.
 * 
 *         思路： 
 *         给出面积  求出长l和宽w 要求l >= w 且 l w 之间差距越小越好 
 *         
 *         递减的时候也可用面积对 当前i 取余数  然后计算高
 * 
 */
public class Solution {
	
	public int[] constructRectangle(int area) {
        // 找到第一个平方数 《= area n 相等直接返回
		int n = 0;
		while(n * n < area) {
			n++;
		}
		if(n * n == area) {
			return new int[]{n,n};
		}
		n--;
		// 否则l 增大  计算面积   大了 w 减小1 小了 l+1
		int l = n;
		int w = n;
		int areaTmp = l * w;
		while(areaTmp != area) {
			if(areaTmp < area) {
				l++;
			} else if(areaTmp > area){
				w--;
			}
			areaTmp = l * w;
		}
		return new int[]{l,w};
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int area = 2;
		int[] sides = solution.constructRectangle(area);
		System.out.println(Arrays.toString(sides));
	}
}
