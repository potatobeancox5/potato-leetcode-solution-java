package com.potato.study.leetcode.p1390;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author liuzhao11
 * 
 * 	1390. Four Divisors
 *  
 *
Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.

If there is no such integer in the array, return 0.



Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.


Constraints:

1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/four-divisors/solution/jian-dan-yi-dong-by-shuang-mu-zhi-lin-3/
 *
 *
 *
 */
public class Solution {


    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int item : nums) {
            result += sum(item);
        }

        return result;
    }

    private int sum(int num) {
        List<Integer> list = new ArrayList<>();
        int count = (int) Math.sqrt(Math.abs(num));
        for (int i = 1; i <= count; i++) {
            if (num % i == 0 && !list.contains(i)) {
                list.add(i);
                list.add(num / i);
            }
        }

        List<Integer> result = list.stream().distinct().collect(Collectors.toList());

        if (result.size() == 4) {
            return list.stream().distinct().mapToInt(o -> o).sum();
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
