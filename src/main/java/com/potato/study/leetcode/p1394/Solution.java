package com.potato.study.leetcode.p1394;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1394. Find Lucky Integer in an Array
 *  
 *
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.



Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
Example 4:

Input: arr = [5]
Output: -1
Example 5:

Input: arr = [7,7,7,7,7,7,7]
Output: 7


Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
 *         
 *         思路：
 *
 *
 *
 */
public class Solution {


    public int findLucky(int[] arr) {

        if (null == arr) {
            return -1;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int value : arr) {
            Integer count = countMap.getOrDefault(value, 0);
            count++;
            countMap.put(value, count);
        }

        int maxKey = -1;
        for (int key : countMap.keySet()) {
            if (key == countMap.get(key)) {
                maxKey = Math.max(key, maxKey);
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{2,2,3,4};
        int res = solution.findLucky(arr);
        System.out.println(res);
        Assert.assertEquals(2, res);


        arr = new int[]{1,2,2,3,3,3};
        res = solution.findLucky(arr);
        System.out.println(res);
        Assert.assertEquals(3, res);

        arr = new int[]{2,2,2,3,3};
        res = solution.findLucky(arr);
        System.out.println(res);
        Assert.assertEquals(-1, res);

        arr = new int[]{5};
        res = solution.findLucky(arr);
        System.out.println(res);
        Assert.assertEquals(-1, res);


        arr = new int[]{7,7,7,7,7,7,7};
        res = solution.findLucky(arr);
        System.out.println(res);
        Assert.assertEquals(7, res);
    }
}
