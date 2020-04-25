package com.potato.study.leetcode.p0844;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	844. Backspace String Compare
 *  
 *         Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 *         
 *         思路：
 *
 * 
 */
public class Solution {

    public boolean backspaceCompare(String s, String t) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (builder1.length() > 0) {
                    if (builder1.length() > 0) {
                        builder1.deleteCharAt(builder1.length() - 1);
                    }
                }
            } else {
                builder1.append(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (builder2.length() > 0) {
                    builder2.deleteCharAt(builder2.length() - 1);
                }
            } else {
                builder2.append(t.charAt(i));
            }
        }
        return builder1.toString().equals(builder2.toString());
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "ab#c";
        String t = "ad#c";
        boolean res = solution.backspaceCompare(s, t);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
