package com.potato.study.leetcode.p0503;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *        503. Next Greater Element II
 * 
 *         Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element.
 *         The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.
 * 
 *
 *
 *         思路：
 *          503. Next Greater Element II

https://blog.csdn.net/tangyuanzong/article/details/79272347

用一个stack存储 当前没处理过的index pop 顺序就是处理的顺序
res 记录结果 初始都是-1
for i num数组
stack为空时push
num i 是否比 peek 大
大的话 记录res 并pop
大不大都push

如果stack不空 在找一遍
这次只 pop 不push


返回res
 *          
 */
public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        // 用一个stack存储 当前没处理过的index pop 顺序就是处理的顺序
        Stack<Integer> unDealIndexSatck = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!unDealIndexSatck.isEmpty() && nums[i] > nums[unDealIndexSatck.peek()]) {
                res[unDealIndexSatck.peek()] = nums[i];
                unDealIndexSatck.pop();
            }
            // 当前节点留着后续进行判断
            unDealIndexSatck.push(i);
        }

        // 如果stack不空 在找一遍
        for (int i = 0; i < nums.length; i++) {
            while (!unDealIndexSatck.isEmpty() && i < unDealIndexSatck.peek() && nums[i] > nums[unDealIndexSatck.peek()]) {
                res[unDealIndexSatck.peek()] = nums[i];
                unDealIndexSatck.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,1};
        int[] res = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
