package com.potato.study.leetcode.p0594;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 *         594. Longest Harmonious Subsequence
 * 
 *         We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:

Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].


Note: The length of the input array will not exceed 20,000.
 * 
 * 
 *         思路：
 *         由于直接求的是子序列，直接计数就可以了 然后使用TreeMap存储，遍历TreeMap
 *         从第二个元素开始，如果与之前相差1 加到之前那个之上，与最大值进行比较
 *         https://www.cnblogs.com/grandyang/p/6896799.html
 *       
 *          
 */
public class Solution {

    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int num : nums) {
            Integer count = countMap.get(num);
            if (null == count) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, count + 1);
            }
        }
        // 遍历 map
        int max = 0;
        boolean isFirst = true;
        int lastKey = 0;
        for (Map.Entry<Integer, Integer> en : countMap.entrySet()) {
            if (isFirst) {
                isFirst = false;
                lastKey = en.getKey();
                continue;
            }
            if (en.getKey() - lastKey == 1) {
                max = Math.max(max, en.getValue() + countMap.get(lastKey));
            }
            lastKey = en.getKey();
        }
        return max;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {1,3,2,2,5,2,3,7};
        int sum = solution.findLHS(nums);
        System.out.println(sum);
    }
}
