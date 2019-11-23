package com.potato.study.leetcode.p0525;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         525. Contiguous Array
 * 
 *         Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.


 * 
 * 
 *         思路：
 *          525. Contiguous Array

https://www.cnblogs.com/liujinhong/p/6472580.html

map key sum值 value prefix index 第一次出现的下表

1将所有的0换成-1

for i
求当前sum
如果map中没sum put sum 1
如果有sum  计算 max  和 i -val


求子数组 组内 01个数相等
 *
 *
 *
 *
 *          
 */
public class Solution {



    public int findMaxLength(int[] nums) {
        // 记录每个sum 第一次出现的index 这样使用 i - index 可以计算出 当前有多少个值
        Map<Integer, Integer> sumFirstIndexMap = new HashMap<>();
        // 1.将所有的0换成-1 不换的话 识别不出来有多少个0
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                nums[i] = -1;
            }
        }
        // 2. 遍历数组，求sum 如果map中没sum put sum 1 如果有sum  计算 max  和 i -val
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLength = Math.max(maxLength, i + 1);
            } else if (sumFirstIndexMap.containsKey(sum)) {
                int firstOccurIndex = sumFirstIndexMap.get(sum);
                maxLength = Math.max(maxLength, i - firstOccurIndex);
            } else {
                sumFirstIndexMap.put(sum, i);
            }
        }
        return maxLength;
    }

	
	public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {0,1};
        int res = solution.findMaxLength(nums);
        System.out.println(res);
        Assert.assertEquals(2, res);

        int[] nums1 = {0,1,0};
        res = solution.findMaxLength(nums1);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
