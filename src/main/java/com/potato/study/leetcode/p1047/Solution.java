package com.potato.study.leetcode.p1047;


/**
 * 
 * @author liuzhao11
 * 
 * 	1047. Remove All Adjacent Duplicates In String
 *  
 *        Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.



Example 1:

Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".


Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
 *         
 *
 *         题目含义：
 *          用一个栈 缓存字母 并进行删除重复字符串
 *          https://blog.csdn.net/wilzxu/article/details/90368553
 *
 *
 *
 */
public class Solution {


    /**
     * 移除相邻的
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        // 遍历数组找到重复字符串
        for (Character ch : s.toCharArray()) {
            if (stack.length() == 0 || stack.charAt(stack.length() - 1) != ch) {
                stack.append(ch);
            } else if (stack.charAt(stack.length() - 1) == ch) {
                stack.deleteCharAt(stack.length() - 1);
            }
        }
        return stack.toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "abbaca";
        String str = solution.removeDuplicates(s);
        System.out.println(str);
    }
}
