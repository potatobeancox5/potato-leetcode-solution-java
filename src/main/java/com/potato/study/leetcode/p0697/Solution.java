package com.potato.study.leetcode.p0697;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 697. Degree of an Array
 *  
 *        Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 *         题目解释：
 *          遍历数组 申请一个map
 *          traverse the array  for each element
 *              if map contaion the num 修改 endIndex
 *              创建结构体
 *         相应结构体计数器 ++
 *
 *         遍历结构体列表 找到最大的出现次数 计算最小值
 *
 *
 *
 * 
 */
public class Solution {

    class NumStatics {
        public int num;
        public int startIndex;
        public int endIndex;
        public int times;

        public NumStatics (int num, int startIndex, int endIndex) {
            this.num = num;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.times = 1;
        }
    }


    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, NumStatics> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            NumStatics currentNumStatics = map.get(num);
            if (null == currentNumStatics) {
                map.put(num, new NumStatics(num, i, i));
            } else {
                currentNumStatics.endIndex = i;
                currentNumStatics.times++;
            }
        }
        int maxTimes = 0;
        int minLne = Integer.MAX_VALUE;
        // 遍历结构体列表 找到最大的出现次数 计算最小值

        for (Map.Entry<Integer, NumStatics> entry : map.entrySet()) {
            NumStatics numStatics = entry.getValue();
            if (maxTimes < numStatics.times) {
                maxTimes = numStatics.times;
                minLne = numStatics.endIndex - numStatics.startIndex + 1;
            } else if (maxTimes == numStatics.times) {
                if (minLne > numStatics.endIndex - numStatics.startIndex + 1) {
                    minLne = numStatics.endIndex - numStatics.startIndex + 1;
                }
            }
        }
        return minLne;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//        int[] nums = {1, 2, 2, 3, 1};// 2
        int[] nums = {1,2,2,3,1,4,2};// 6
        int num = solution.findShortestSubArray(nums);
        System.out.println(num);
    }
}
