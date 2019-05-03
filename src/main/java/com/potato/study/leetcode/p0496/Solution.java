package com.potato.study.leetcode.p0496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         496. Next Greater Element I
 * 
 *         You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
For number 2 in the first array, the next greater number for it in the second array is 3.
For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 *
 *
 *         题目含义：
 *          找到当前nums1中的节点，在nums2中对应的下一个大于它的数字的数字
 *         思路：
            https://blog.csdn.net/TheSnowBoy_2/article/details/54923043
            用笔和纸模拟一遍吧
            开一个栈记录之前没有找到之后最大值的数字，
            遍历num2 当前cur
                如果当前栈中的值 小于当前 cur 依次出栈 并记录map key 和value 当前最大值
                如果当前栈中的值 大于 当前cur cur入栈
 * 
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 生成map对应关系
        for (int cur : nums2) {
            while (!stack.isEmpty() && stack.peek() < cur) {
                map.put(stack.pop(), cur);
            }
            stack.add(cur);
        }
        // nums1 中找到对应的值 记录下来
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};

        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] res = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
