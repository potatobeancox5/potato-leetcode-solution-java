package com.potato.study.leetcode.p0976;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	976. Largest Perimeter Triangle
 *  
 *         Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.

If it is impossible to form any triangle of non-zero area, return 0.



Example 1:

Input: [2,1,2]
Output: 5
Example 2:

Input: [1,2,1]
Output: 0
Example 3:

Input: [3,2,3,4]
Output: 10
Example 4:

Input: [3,6,2,3]
Output: 8


Note:

3 <= A.length <= 10000
1 <= A[i] <= 10^6
 *         
 *         思路：
 *         https://blog.csdn.net/fuxuemingzhu/article/details/86426988
 *         上文证明
 *         最大的周长一定是最大边和次大边相邻
 *         排序得到
 *         a,b,c,d,e,f,g,h
 *         f <= g <= h
 *         因此只需保证 f + g > h 即可
 * 
 */
public class Solution {

    public int largestPerimeter(int[] arr) {
        int perimeter = 0;
        if (null == arr || arr.length < 3) {
            return perimeter;
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            int a = arr[i];
            int b = arr[i - 1];
            // 第三个点
            for (int j = i - 2; j >= 0 ; j--) {
                int c = arr[j];
                if (b + c > a) {
                    return a + b + c;
                }
            }
        }
        return perimeter;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {2,1,2};
//		int[] arr = {1,2,1};
		int[] arr = {3,6,2,3};
        int result = solution.largestPerimeter(arr);
        System.out.println(result);
    }
}
