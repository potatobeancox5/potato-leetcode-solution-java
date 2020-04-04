package com.potato.study.leetcode.p0830;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	830. Positions of Large Groups
 *  
 *         In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.



Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]


Note:  1 <= S.length <= 1000


 *         
 *         思路：
 *
 *         830. Positions of Large Groups
https://blog.csdn.net/lym940928/article/details/80235033
 *
 * 
 */
public class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {
        int startPos = 0;
        int count = 1;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                count++;
            } else {
                // 中断了 看看 count 情况如何
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(startPos);
                    list.add(startPos + count - 1);
                    res.add(list);
                }
                // reset
                count = 1;
                startPos = i+1;
            }
        }

        // 最后一组 直接结束的那种
        if (count >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(startPos);
            list.add(startPos + count - 1);
            res.add(list);
        }

        return res;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "abbxxxxzzy";
        List<List<Integer>> result = solution.largeGroupPositions(s);
        System.out.println(result);

        s = "abc";
        result = solution.largeGroupPositions(s);
        System.out.println(result);

        s = "abcdddeeeeaabbbcd";
        result = solution.largeGroupPositions(s);
        System.out.println(result);
    }
}
