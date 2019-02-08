package com.potato.study.leetcode.p0821;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	821. Shortest Distance to a Character
 *  
 *         Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
 *         
 *         思路：
 *
 * 
 */
public class Solution {

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        List<Integer> position = new ArrayList<>();
        // 先计算出来每个c的位置
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                position.add(i);
            }
        }
        // 遍历每个s 对c求最小值
        for (int i = 0; i < result.length; i++) {
            if (s.charAt(i) == c) {
                result[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int pos : position) {
                    if (min > Math.abs(pos - i)) {
                        min = Math.abs(pos - i);
                    }
                }
                result[i] = min;
            }
        }
        return result;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "loveleetcode";
		char c = 'e';
        int[] ints = solution.shortestToChar(s, c);
        System.out.println(Arrays.toString(ints));
    }
}
