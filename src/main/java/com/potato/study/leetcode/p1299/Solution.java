package com.potato.study.leetcode.p1299;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1299. Replace Elements with Greatest Element on Right Side
 *  
 *
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 *         
 *         思路：
 *          使用该数组右边最大的元素替换这个位置
 *
 *          遍历数组 从右往左 维护右侧最大值
 *
 *
 *
 *

 *
 */
public class Solution {

    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{};
        int[] res = solution.replaceElements(arr);
        System.out.println(Arrays.toString(res));

    }
}
