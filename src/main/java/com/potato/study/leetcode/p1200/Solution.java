package com.potato.study.leetcode.p1200;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1200. Minimum Absolute Difference
 *  
 *
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr


Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]


Constraints:

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
 *         
 *         思路：
 *
 *
 *

 *
 */
public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        // 找到 最小距离
        int min = Integer.MAX_VALUE;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i] - arr[i-1];

            if (value > min) {
                continue;
            }

            if (value < min) {
                resultList = new ArrayList<>();
                min = value;

            }

            List<Integer> list = new ArrayList<>();
            list.add(arr[i-1]);
            list.add(arr[i]);
            resultList.add(list);

        }
        return resultList;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{4,2,1,3};
        List<List<Integer>> res = solution.minimumAbsDifference(arr);
        System.out.println(res);



    }
}
