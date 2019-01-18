package com.potato.study.leetcode.p0771;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	771. Jewels and Stones
 *  
 *         You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 *         
 *         思路：
 *         t
 * 
 */
public class Solution {

    public int numJewelsInStones(String j, String s) {
        Set<Character> set = new HashSet<>();
        for (char ch:j.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for (char ch: s.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }
        return count;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String j = "aA";
		String s = "aAAbbbb";
        int stones = solution.numJewelsInStones(j, s);
        System.out.println(stones);
    }
}
