package com.potato.study.leetcode.p0916;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	916. Word Subsets
 *  
 *      We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.



Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]


Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].

 *         
 *         题目含义：
 *              https://leetcode-cn.com/problems/word-subsets/solution/dan-ci-zi-ji-by-leetcode/
 *         思路：
 *
 *
 *
 */
public class Solution {

    public List<String> wordSubsets(String[] arr, String[] brr) {
        int[] bmax = count("");
        for (String b: brr) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList<>();
        search:
        for (String a: arr) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    continue search;
                }
            }
            ans.add(a);
        }
        return ans;
    }

    private int[] count(String str) {
        int[] ans = new int[26];
        for (char c: str.toCharArray()) {
            ans[c - 'a']++;
        }
        return ans;
    }
}
