package com.potato.study.leetcode.p1296;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author liuzhao11
 * 
 * 	1296. Divide Array in Sets of K Consecutive Numbers
 *  
 *
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.



Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true
Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length
Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/
 *         
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/solution/java-pai-xu-hashmap-booleanshu-zu-by-gfu/
 *

 *
 */
public class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>(len);
        for (int i = 0; i < len; ++i){
            map.computeIfAbsent(nums[i], unused -> new LinkedList<>()).addLast(i);
        }
        boolean[] selected = new boolean[len];
        while (!map.isEmpty()) {
            for (int i = 0; i < len; ++i)
                if (!selected[i]) { //当前下标的值未被使用，则将其作为起点。
                    selected[i] = true; //将当前下标的值标记为 已使用
                    //操作map，模拟“标记当前下标的值 已使用”
                    LinkedList<Integer> list = map.get(nums[i]);
                    list.removeFirst();
                    if (list.isEmpty()) {
                        map.remove(nums[i]);
                    }

                    for (int j = 1; j < k; ++j) {
                        list = map.get(nums[i] + j);
                        if (list == null) {
                            return false; //在未使用的数中，nums[i] + j不存在。
                        }
                        selected[list.removeFirst()] = true;
                        if (list.isEmpty()) {
                            map.remove(nums[i] + j);
                        }
                    }
                }
        }
        return true;
    }
}
