package com.potato.study.leetcode.p1207;


import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1207. Unique Number of Occurrences
 *  
 *
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true


Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
 *         
 *         思路：
 *
 *
 *

 *
 */
public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> timesMap = new HashMap<>();

        for (int num : arr) {
            Integer time = timesMap.getOrDefault(num, 0);
            time++;
            timesMap.put(num, time);
        }
        Set<Integer> set = new HashSet<>(timesMap.values());
        return set.size() == timesMap.size();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{1,2,2,1,1,3};
        boolean res = solution.uniqueOccurrences(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{1,2};
        res = solution.uniqueOccurrences(arr);
        System.out.println(res);
        Assert.assertEquals(false, res);

        arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        res = solution.uniqueOccurrences(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

    }
}
