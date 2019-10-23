package com.potato.study.leetcode.p0424;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         424. Longest Repeating Character Replacement
 * 
 *         Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

In one operation, you can choose any character of the string and change it to any other uppercase English character.

Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.


Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.



        思路：

424. Longest Repeating Character Replacement


https://leetcode.com/problems/longest-repeating-character-replacement/description/


https://blog.csdn.net/a921122/article/details/55504777

滑动窗口
 * https://www.cnblogs.com/reboot329/p/5968393.html
 *
 *      int left = 0 窗口左边
 *      int maxInWindow = 0 窗口内部某个字母的最大值
 *      int max
 *      for right 0 - len 作为窗口右边
 *          当前ch 进行计数
 *          maxInWindow = max 「maxInWindow， 当前ch计数」
 *          当前窗口大小 windowSize = right - left + 1
 *          if windowSize - maxInWindow <= k
 *              说明当前 windowSize 可能为最大值
 *          else
 *              说明当前窗口的l 需要往右移动了 并减少计数 count l -- l++
 * 
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        // 窗口左边
        int left = 0;
        // 窗口内部某个字母的最大值
        int maxInWindow = 0;
        int maxRepeating = 0;
        int[] count = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch - 'A']++;
            // maxInWindow = max 「maxInWindow， 当前ch计数」
            maxInWindow = Math.max(maxInWindow, count[ch - 'A']);
            // 当前窗口大小 windowSize = right - left + 1
            int windowSize = right - left + 1;
            if (windowSize - maxInWindow <= k) {
                // 说明当前 windowSize 可能为最大值 也可能需要对窗口进行扩大
                maxRepeating = Math.max(maxRepeating, windowSize);
            } else {
                // 说明当前窗口的l 需要往右移动了 并减少计数 count l -- l++
                char leftCh = s.charAt(left);
                left++;
                count[leftCh - 'A']--;
            }

        }
        return  maxRepeating;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "ABAB";
		int k = 2;
        int count = solution.characterReplacement(s, k);
        System.out.println(count);
        Assert.assertEquals(4, count);


        s = "AABABBA";
        k = 1;
        count = solution.characterReplacement(s, k);
        System.out.println(count);
        Assert.assertEquals(4, count);



    }
}
