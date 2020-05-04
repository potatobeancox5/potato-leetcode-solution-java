package com.potato.study.leetcode.p1170;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1170. Compare Strings by Frequency of the Smallest Character
 *  
 *
Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.



Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").


Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character/solution/java5msgao-xiao-ti-gong-liang-chong-xie-fa-by-raym/
 *
 *
 *
 */
public class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 计算一遍 words 的得分 然后排序
        int[] score = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            score[i] = f(words[i]);
        }
        Arrays.sort(score);
        // 遍历 计算  queries 中  计算最终结果
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = f(queries[i]);
            int count = 0;
            for (int j = score.length - 1; j >=0 ; j--) {
                if (cur < score[j]) {
                    count++;
                } else {
                    break;
                }
            }
            result[i] = count;
        }
        return result;
    }

    /**
     * 求word 中 最小字母的数量
     * @param word
     * @return
     */
    private int f(String word) {
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return count[i];
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();


        String[] queries = new String[]{"cbd"};
        String[] words = new String[]{"zaaaz"};
        int[] count = solution.numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(count)); // 1
    }
}
