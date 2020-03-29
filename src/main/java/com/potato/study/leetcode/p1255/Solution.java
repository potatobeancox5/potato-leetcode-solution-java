package com.potato.study.leetcode.p1255;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1255. Maximum Score Words Formed by Letters
 *  
 *
Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.



Example 1:

Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
Output: 23
Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.
Example 2:

Input: words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
Output: 27
Explanation:
Score  a=4, b=4, c=4, x=5, z=10
Given letters, we can form the words "ax" (4+5), "bx" (4+5) and "cx" (4+5) with a score of 27.
Word "xxxz" only get a score of 25.
Example 3:

Input: words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
Output: 0
Explanation:
Letter "e" can only be used once.


Constraints:

1 <= words.length <= 14
1 <= words[i].length <= 15
1 <= letters.length <= 100
letters[i].length == 1
score.length == 26
0 <= score[i] <= 10
words[i], letters[i] contains only lower case English letters.
 *         
 *         思路：
 *
 *          https://www.cnblogs.com/onePunchCoder/p/11830504.html
 *          用letters 中的字符拼接words 中的字符串，给出最大得分。 sum
 *
 *
 *          https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/524329/clean-Java-solution-bitmasking
 *
 *
 *

 *
 */
public class Solution {

    // 维护一个 map word 分数

    // 统计 letters


    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        // 1 计算每个单词 和 单词对应的得分
        int[] letterCount = this.countWords(letters);
        int[] wordScore = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            // compute each word score
            int sum = 0;
            for (char ch : words[i].toCharArray()) {
                sum += score[ch - 'a'];
            }
            wordScore[i] = sum;
        }
        int maxScore = 0;
        // 对n个单词 1 <= words.length <= 14 采用一个mask 表示 是否选择这个单词，并对每种选择进行分数计算
        for (int i = 1; i < (1 << words.length); i++) {
            int mask = 1;
            // 用于比较单词 是否合法
            String currentStr = "";
            int totalScore = 0;
            for (int j = 0; j < words.length; j++) {
                // 判断当前位置有没有单词
                if ((i & mask) > 0) {
                    currentStr += words[j];
                    totalScore += wordScore[j];
                }

                mask = mask << 1;
            }

            if (this.isWordValid(countWords(currentStr.toCharArray()), letterCount)) {
                maxScore = Math.max(maxScore, totalScore);
            }
        }

        return maxScore;
    }

    /**
     * 计数器 计算 letters 中每个字母出现的次数
     * @return
     */
    private int[] countWords (char[] letters) {
        int[] chCount = new int[26];

        for (int i = 0; i < letters.length; i++) {
            chCount[letters[i] - 'a']++;
        }
        return chCount;
    }

    /**
     * 判断 letersCount 是否可以 容纳单词 word
     * @param wordCount
     * @param letersCount
     * @return
     */
    private boolean isWordValid(int[] wordCount, int[] letersCount) {
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > 0 && wordCount[i] > letersCount[i]) {
                return false;
            }
        }
        return true;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] score = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int res = solution.maxScoreWords(words, letters, score);
        System.out.println(res);
        Assert.assertEquals(23, res);


        words = new String[]{"xxxz","ax","bx","cx"};
        letters = new char[]{'z','a','b','c','x','x','x'};
        score = new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        res = solution.maxScoreWords(words, letters, score);
        System.out.println(res);
        Assert.assertEquals(27, res);


        words = new String[]{"leetcode"};
        letters = new char[]{'l','e','t','c','o','d'};
        score = new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
        res = solution.maxScoreWords(words, letters, score);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
