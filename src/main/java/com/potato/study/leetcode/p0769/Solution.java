package com.potato.study.leetcode.p0769;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	769. Max Chunks To Make Sorted
 *  
 *         Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].


 *   题目大意：
 *
 *
 *
 *   解题思路：
 *      https://blog.csdn.net/liuchuo/article/details/79187214

 *      遍历 arr 找到 max == i count ++
 *
 *
 * 
 */
public class Solution {

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            max = Math.max(max, arr[i]);

            if (max == i) {
                count++;
            }
        }
        return count;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = {4,3,2,1,0};
        int num = solution.maxChunksToSorted(arr);
        System.out.println(num);
        Assert.assertEquals(1, num);

        arr = new int[]{1,0,2,3,4};
        num = solution.maxChunksToSorted(arr);
        System.out.println(num);
        Assert.assertEquals(4, num);
    }
}
