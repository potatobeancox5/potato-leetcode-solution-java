package com.potato.study.leetcode.p0819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	819. Most Common Word
 *  
 *        Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
 *         
 *         思路：
 *          禁用的word 是小写给出的，但是段落是既存在大写又存在小写的
 *
 *          1. 按照空格分隔
 *          2. 遍历每个分隔 使用map记次数 （如果命中hit单词不要记录）
 *          3. 遍历map输出最多的单词
 *
 * 
 */
public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        // 转成set
        Set<String> bannedSet = new HashSet<>();
        if (null != banned) {
            for (String bannedWord : banned) {
                bannedSet.add(bannedWord);
            }
        }
        String[] split = paragraph.split(" ");
        Map<String, Integer> word2Times = new HashMap<>();

        return null;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
//        int result = solution.pruneTree(grid);
//        System.out.println(result);
    }
}
