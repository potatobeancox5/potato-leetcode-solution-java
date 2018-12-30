package com.potato.study.leetcode.p0228;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *      228. Summary Ranges
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 * 题目解释：
 *     给一组数，求字符串表示其范围
 * 思路：
 *  如参数是排序后的
 *  记录第一个数
 *  
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        int startNum = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            if (i == 0) {
                continue;
            }
            if (nums[i] != nums[i-1] + 1) { // 组装参数并写入返回值
                if (startNum == nums[i - 1]) {
                    result.add(startNum + "");
                    startNum = nums[i];
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(startNum).append("->").append(nums[i - 1]);
                startNum = nums[i];
                result.add(sb.toString());
            }
        }
        if (startNum != nums[nums.length - 1]) {
            StringBuilder sb = new StringBuilder();
            sb.append(startNum).append("->").append(nums[nums.length - 1]);
            result.add(sb.toString());
        } else {
            result.add(startNum + "");
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
        List<String> list = solution.summaryRanges(nums);
        System.out.println(list);
    }

}
