package com.potato.study.leetcode.p1287;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1287. Element Appearing More Than 25% In Sorted Array
 *  
 *
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.



Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6


Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
 *         
 *         思路：
 *          287. Element Appearing More Than 25% In Sorted Array

https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/solution/0ms-100-java-shuang-zhi-zhen-jian-ji-4xing-by-rabb/

找到 1/4 长度值

从0开始找 如果 i 等于 四分之一后的位置 那么就是所求
 *
 *
 *
 */
public class Solution {

    public int findSpecialInteger(int[] arr) {
        int interval = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + interval]) {
                return arr[i];
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1,2,2,6,6,6,6,7,10};
        int res = solution.findSpecialInteger(arr);
        System.out.println(res);
        Assert.assertEquals(6, res);


    }
}
