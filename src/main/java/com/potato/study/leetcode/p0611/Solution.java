package com.potato.study.leetcode.p0611;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         611. Valid Triangle Number
 * 
 *        Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
 *
 *
 *         思路：
 *
 *         611. Valid Triangle Number

https://blog.csdn.net/excellentlizhensbfhw/article/details/81951599

排序 只要满足两边只和大于第三遍就行
升序排序
for i 0  len-3
for j i+1 len-2
left j+1
right   len -1
while left小于等于 rifht
target num i 加 num j
求 mid
if target 《=num mid
right = mid-1
else
left = mid +1

计算
res += right- j
 *
 *
 *
 */
public class Solution {

    public int triangleNumber(int[] nums) {

        // sort
        Arrays.sort(nums);
        // compute the 2 short and compare 1 long
        int len = nums.length;
        int res = 0;
        for (int i = 0; i <= len - 3; i++) {
            for (int j = i+1; j <= len - 2; j++) {
                int left = j+1;
                int right = len-1;
                int target = nums[i] + nums[j];
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                res += (right - j);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {

		Solution solution = new Solution();
        int[] nums = {2,2,3,4};
        int number = solution.triangleNumber(nums);
        System.out.println(number);
        Assert.assertEquals(3, number);

    }
}
