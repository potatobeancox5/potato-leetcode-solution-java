package com.potato.study.leetcode.p0784;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	784. Letter Case Permutation
 *  
 *        Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.


 *
 *
 *   解题思路：
 *   784. Letter Case Permutation

递归生成result index

index 》= len return
当前字符串入list
递归生成 list  index +1
当前字符串改成小写或者大写
递归生成 index
 * 
 */
public class Solution {

    public List<String> letterCasePermutation(String str) {
        Set<String> res = new HashSet<>();
        try {
            Long.parseLong(str);
            res.add(str);
            return new ArrayList<>(res);
        } catch (Exception e) {
        }
        generateWordByIndex(str, 0, res, false);
        return new ArrayList<>(res);
    }

    /**
     * 生成当前word
     * @param str
     * @param index
     */
    private void generateWordByIndex(String str, int index, Set<String> tmpStrRes, boolean hasChanged) {
        if (index >= str.length()) {
            return;
        }
        if (Character.isDigit(str.charAt(index))) {
            generateWordByIndex(str, index + 1, tmpStrRes, false);
        } else {
            tmpStrRes.add(str);
            if (!hasChanged) {
                String newStr = str.substring(0, index) +
                        (Character.isLowerCase(str.charAt(index))? Character.toUpperCase(str.charAt(index))
                                : Character.toLowerCase(str.charAt(index)))
                        + str.substring(index + 1);
                generateWordByIndex(newStr, index, tmpStrRes, true);
            }
            generateWordByIndex(str, index + 1, tmpStrRes, false);
        }
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String str = "a1b2";
//		String str = "3z4";
		String str = "12345";
        List<String> list = solution.letterCasePermutation(str);
        System.out.println(list);
    }
}
