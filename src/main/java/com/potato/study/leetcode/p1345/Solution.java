package com.potato.study.leetcode.p1345;


import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1345. Jump Game IV
 *  
 *
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.



Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You don't need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
Example 4:

Input: arr = [6,1,9]
Output: 2
Example 5:

Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
Output: 3


Constraints:

1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/jump-game-iv/solution/javayan-du-you-xian-sou-suo-onjie-fa-by-jackie-tie/
 *
 *
 *
 *

 *
 */
public class Solution {

    public int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        Map<Integer, Set<Integer>> value2Index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            value2Index.computeIfAbsent(arr[i], k -> new HashSet<>()).add(i);
        }

        int minStep = 0;
        Set<Integer> hasReached = new HashSet<>();
        Queue<Integer> nextStep = new LinkedList<>();
        nextStep.add(arr.length-1);
        hasReached.add(arr.length-1);
        while (!nextStep.isEmpty()) {
            int count = nextStep.size();
            minStep++;
            for (int i = 0; i < count; i++) {
                int index = nextStep.poll();
                value2Index.get(arr[index]).remove(index);
                Set<Integer> temp = new HashSet<>(value2Index.get(arr[index]));
                if (index - 1 >= 0) {
                    temp.add(index-1);
                }
                if (index + 1 < arr.length) {
                    temp.add(index + 1);
                }
                for (int a : temp) {
                    if (a == 0) {
                        return minStep;
                    }
                    if (!hasReached.contains(a)) {
                        hasReached.add(a);
                        nextStep.add(a);
                    }
                }
            }
        }
        return minStep;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{100,-23,-23,404,100,23,23,23,3,404};
        int res = solution.minJumps(arr);
        System.out.println(res);
        Assert.assertEquals(3, res);

    }
}
