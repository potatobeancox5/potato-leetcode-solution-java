package com.potato.study.leetcode.p0442;

import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *   442. Find All Duplicates in an Array
 * 
 *    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * 			
 *     思路：
 *      https://www.cnblogs.com/grandyang/p/6209746.html
        遍历a[i] 如果为负数 变成正数进行下面操作
        取a[a[i] - 1] 若< 0 说明重复 ，否则 将a[a[i] - 1]  设置为负数
 *     
 * 			
 * 	
 */	
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        return null;
    }
}
