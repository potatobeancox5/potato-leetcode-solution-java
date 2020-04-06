package com.potato.study.leetcode.p0820;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @author liuzhao11
 * 
 * 	820. Short Encoding of Words
 *  
 *         Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?

Example:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: S = "time#bell#" and indexes = [0, 2, 5].


Note:

1 <= words.length <= 2000.
1 <= words[i].length <= 7.
Each word has only lowercase letters.
 *         
 *         思路：
 *          给单词记性编码 得到 一个字符串 返回 最小字符串 大小
 *
 *          遍历 单词 如果可以endWith 去掉短的那个单词 最终 计算单词 长度和 + 数量 - 1
 *
 *          https://www.cnblogs.com/aaronliu1991/p/12587061.html
 *
 * 
 */
public class Solution {

    public int minimumLengthEncoding(String[] words) {
        // 全量放入 set
        Set<String> set = new HashSet<>(Arrays.asList(words));
        // 遍历 words 对于每个word 的每个 subStr 从set 中删除
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String endString = word.substring(i);
                set.remove(endString);
            }
        }
        // 遍历 剩下的 set 计算总长度 + #
        int totalLen = 0;
        for (String word : set) {
            totalLen += word.length();
        }
        totalLen += set.size();
        return totalLen;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        String[] words = new String[]{"time", "me", "bell"};
        int len = solution.minimumLengthEncoding(words);
        System.out.println(len);
        Assert.assertEquals(10, len);
    }
}
