package com.potato.study.leetcode.p0833;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	833. Find And Replace in String
 *  
 *         To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.

Example 1:

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
"ec" doesn't starts at index 2 in the original S, so we do nothing.
Notes:

0 <= indexes.length = sources.length = targets.length <= 100
0 < indexes[i] < S.length <= 1000
All characters in given inputs are lowercase letters.


 *         
 *         思路：
 *         833. Find And Replace in String
https://blog.csdn.net/shey666/article/details/80554563
组织数据结构
index word afterword 放在堆里 index大根堆
tmp
每次pop 一个元素
if word eq s子串
tmp 替换 子串相同位置 为 新串
 *
 * https://leetcode-cn.com/problems/find-and-replace-in-string/solution/zi-fu-chuan-zhong-de-cha-zhao-yu-ti-huan-by-leetco/
 * 
 */
public class Solution {

    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        // 使用 match[ix] = i; 记录当前位置匹配的 index
        int[] matchIndex = new int[s.length()];
        Arrays.fill(matchIndex, -1);
        for (int i = 0; i < indexes.length; i++) {
            int startIndex = indexes[i];
            if (s.substring(startIndex, startIndex + sources[i].length()).equals(sources[i])) {
                matchIndex[startIndex] = i;
            }
        }
        // 从 0开始 记录遍历每个位置的匹配情况 匹配上 坐标移动一下
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            if (matchIndex[i] >= 0) {
                builder.append(targets[matchIndex[i]]);
                i += sources[matchIndex[i]].length();
            } else {
                builder.append(s.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }


	public static void main(String[] args) {

        Solution solution = new Solution();

        String s = "abcd";
        int[] indexes = new int[]{0,2};
        String[] sources = new String[]{"a","cd"};
        String[] targets = new String[]{"eee","ffff"};

        String res = solution.findReplaceString(s, indexes, sources, targets);
        System.out.println(res);
        Assert.assertEquals("eeebffff", res);

        s = "vmokgggqzp";
        indexes = new int[]{3,5,1};
        sources = new String[]{"kg","ggq","mo"};
        targets = new String[]{"s","so","bfr"};

        res = solution.findReplaceString(s, indexes, sources, targets);
        System.out.println(res);
        Assert.assertEquals("vbfrssozp", res);

    }
}
