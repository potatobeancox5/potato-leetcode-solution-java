package com.potato.study.leetcode.p0768;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	768. Max Chunks To Make Sorted II
 *  
 *         This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.

Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
Example 2:

Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 2000].
arr[i] will be an integer in range [0, 10**8].

 *   题目大意：
 *
 *      排序后的数组前i个元素累加的和等于原数组前i个数累加的和时可以分为一个块
 *
 *   解题思路：
 *      https://blog.csdn.net/liuchuo/article/details/79187465
 *
 *
 *
 * 
 */
public class Solution {

    public int maxChunksToSorted(int[] arr) {

        long sortedSum = 0;
        long sum = 0;

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sortedSum += sortedArr[i];
            sum += arr[i];
            if (sortedSum == sum) {
                count++;
            }
        }
        return count;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = {5,4,3,2,1};
        int num = solution.maxChunksToSorted(arr);
        System.out.println(num);
        Assert.assertEquals(1, num);

        arr = new int[]{2,1,3,4,4};
        num = solution.maxChunksToSorted(arr);
        System.out.println(num);
        Assert.assertEquals(4, num);
    }
}
