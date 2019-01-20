package com.potato.study.leetcode.p0944;

/**
 * 
 * @author liuzhao11
 * 
 * 	944. Delete Columns to Make Sorted
 *  
 *       We are given an array A of N lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)

Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in non-decreasing sorted order.

Return the minimum possible value of D.length.



Example 1:

Input: ["cba","daf","ghi"]
Output: 1
Explanation:
After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
Example 2:

Input: ["a","b"]
Output: 0
Explanation: D = {}
Example 3:

Input: ["zyx","wvu","tsr"]
Output: 3
Explanation: D = {0, 1, 2}
 *         
 *         题目含义：
 *          删除列 使得最终留下来的列 都是升序的
 *
 *         思路：
 *          遍历一遍 出现降序计数器++，返回计数器数字
 *
 *
 * 
 */
public class Solution {

    public int minDeletionSize(String[] words) {
        int count = 0;
        if (null == words || words.length <= 1) {
            return count;
        }
        for (int i = 0; i < words[0].length() ; i++) {// 控制列
            for (int j = 1; j < words.length ; j++) { // 控制行
                if (words[j].charAt(i) <  words[j-1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = {"zyx","wvu","tsr"};
        int result = solution.minDeletionSize(words);
        System.out.println(result);
    }
}
