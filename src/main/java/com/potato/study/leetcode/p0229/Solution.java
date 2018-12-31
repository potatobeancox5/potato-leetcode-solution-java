package com.potato.study.leetcode.p0229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *      229. Majority Element II
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 *
 * 题目解释：
 *  找出数组中存在的大于 3/n 的元素
 * 思路：
 *  投票法
 *      记录当前两个数字 a b 遍历数组 c
 *      计数器         aCount bCount
 *      如果 a b c 都不同
 *          用c 替换 ab 中 count为0
 *          另一个count--
 *      如果 c 与 a b 一致 一致的count++ 不一致的不变
 *      https://blog.csdn.net/xudli/article/details/46784149
 *  
 */
public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return resultList;
        }
        int a = nums[0];
        int aCount = 1;
        if (nums.length == 1) {
            resultList.add(nums[0]);
            return resultList;
        }
        int b = Integer.MIN_VALUE;
        int bCount = 0;

        for (int i = 1; i < nums.length; i++) {
            int c = nums[i];
            if (c == a) {
                aCount++;
            } else if (c == b) {
                bCount++;
            } else if (aCount == 0) {
                a = c;
                aCount = 1;
            } else if (bCount == 0) {
                b = c;
                bCount = 1;
            } else {// c != a && c != b 且次数不为0
                aCount--;
                bCount--;
            }
        }
        // 检验ab
        aCount = 0;
        bCount = 0;
        for (int num : nums) {
            if (num == a) {
                aCount++;
            } else if (num == b) {
                bCount++;
            }
        }
        if (aCount * 3 > nums.length) {
            resultList.add(a);
        }
        if (bCount * 3 > nums.length) {
            resultList.add(b);
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {3,2,3}; // 3
//        int[] nums = {2,2,1,3};// 2
//        int[] nums = {0,3,4,0};// 0
//        int[] nums = {1,1,1,3,3,2,2,2}; // 1 2
        int[] nums = {1,1,1,2,3,4,5,6};// 1
//        int[] nums = {2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};//[9,3]

        List<Integer> result = solution.majorityElement(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
