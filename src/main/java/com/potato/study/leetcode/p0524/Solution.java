package com.potato.study.leetcode.p0524;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         524. Longest Word in Dictionary through Deleting
 * 
 *         Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 *         If there are more than one possible results,
 *         return the longest word with the smallest lexicographical order.
 *         If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output:
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.


 * 
 * 
 *         思路：
 *         给定一个字典和一个字符串，求其中能通过删除字符串中字母，构成字典的最长的 字典中的字符串
 *
 *         524. Longest Word in Dictionary through Deleting

给一个单词 删除 字母 给一个列表我找到其中最长的串

给定字符串先 按 长度 再按照字母排序

依次找

逐个匹配

复用522子方法
 *
 *
 *
 *
 *          
 */
public class Solution {

    public String findLongestWord(String s, List<String> d) {
        // 排序
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) {
                    return o1.charAt(0) - o2.charAt(0);
                }
                return o2.length() - o1.length();
            }
        });
        for (String word : d) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }
        return "";
    }

    /**
     * 判断 a是否是b的子序列
     * （a长度 小于b 长度）
     * @param a
     * @param b
     * @return
     */
    private boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }
        if (a.equals(b)) {
            return true;
        }
        // 记录当前找到 index位于 a的位置
        int index = 0;
        for (int i = 0; i < b.length(); i++) {
            if (index == a.length()) {
                break;
            }
            if (a.charAt(index) == b.charAt(i)) {
                index++;
            }
        }
        return index == a.length();
    }

	
	public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "abpcplea";
        List<String> d = Arrays.asList(new String[]{"ale","apple","monkey","plea"});
        String res = solution.findLongestWord(s, d);
        System.out.println(res);
        Assert.assertEquals("apple", res);

        s = "abpcplea";
        d = Arrays.asList(new String[]{"a","b","c"});
        res = solution.findLongestWord(s, d);
        System.out.println(res);
        Assert.assertEquals("a", res);
    }
}
