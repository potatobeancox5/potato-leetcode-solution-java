package com.potato.study.leetcode.p1408;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1408. String Matching in an Array
 *  
 *
Given an array of string words. Return all strings in words which is substring of another word in any order.

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].



Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.
 *         
 *         思路：
 *          拼成一个长串，分隔 找 indexod 和lastindexof 不一致 就是所求
 *
 *
 *
 *
 */
public class Solution {


    public List<String> stringMatching(String[] words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word).append(",");
        }
        String wholeWords = builder.toString();
        List<String> resultList = new ArrayList<>();
        for (String word : words) {
            int index1 = wholeWords.indexOf(word);
            int index2 = wholeWords.lastIndexOf(word);
            if (index1 >= 0 && index2 >= 0 && index1 != index2) {
                resultList.add(word);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words = new String[]{"mass","as","hero","superhero"};
        List<String> res = solution.stringMatching(words);
        System.out.println(res); // "as","hero"


    }
}
