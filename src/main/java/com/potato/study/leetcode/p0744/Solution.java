package com.potato.study.leetcode.p0744;

/**
 * 
 * @author liuzhao11
 * 
 * 	744. Find Smallest Letter Greater Than Target
 *  
 *         Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 *
 * 思路： 两次循环
 *          第一次没有找到的话 第二次 直接+ 26 进行比较
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        //first times
        for (char ch : letters) {
            if (ch > target) {
                return ch;
            }
        }
        // second times
        for (char ch : letters) {
            if (ch + 26 > target) {
                return ch;
            }
        }
        return 'A';
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		char[] letters = {'c', 'f', 'j'};
		char target = 'z';
		char totalCost = solution.nextGreatestLetter(letters, target);
		System.out.println(totalCost);
	}
}
