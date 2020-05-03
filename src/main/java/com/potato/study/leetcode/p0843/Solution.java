package com.potato.study.leetcode.p0843;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	843. Guess the Word
 *  
 *         This problem is an interactive problem new to the LeetCode platform.

We are given a word list of unique words, each word is 6 letters long, and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.  The letters of each word in those testcases were chosen independently at random from 'a' to 'z', such that every word in the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:

master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
 *         
 *         思路：
 *
 *         https://leetcode-cn.com/problems/guess-the-word/solution/cai-cai-zhe-ge-dan-ci-by-leetcode/
 *
 * 
 */
public class Solution {
    interface Master {
        int guess(String word);
    }


    // 存储 H[i][j] 为 wordlist[i] 和 wordlist[j] 单词匹配数
    private int[][] h;

    public void findSecretWord(String[] wordlist, Master master) {
        // 初始化 单词匹配数
        int n = wordlist.length;
        h = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int match = 0;
                for (int k = 0; k < 6; k++) {
                    if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) {
                        match++;
                    }
                    h[i][j] = match;
                    h[j][i] = match;
                }
            }
        }
        //
        List<Integer> possible = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            possible.add(i);
        }
        List<Integer> path = new ArrayList();

        while (!possible.isEmpty()) {
            //  从之前的猜测记录里选择一个可能的单词
            int guessIndex = solve(possible, path);
            // 猜测一个字符
            int matches = master.guess(wordlist[guessIndex]);
            // 已经猜测了n次 没有猜到
            if (matches == wordlist[0].length()) {
                return;
            }
            List<Integer> possibleTemp = new ArrayList();
            // 遍历 h 找到可能的单词
            for (Integer j: possible) {
                if (h[guessIndex][j] == matches) {
                    possibleTemp.add(j);
                }
            }
            // 新一轮的猜测
            possible = possibleTemp;
            path.add(guessIndex);
        }


    }

    /**
     * 生成 possible 数组
     * @param possible
     * @param path  之前踩了啥
     * @return
     */
    private int solve(List<Integer> possible, List<Integer> path) {
        // 可能字符串里边 只有一个 返回
        if (possible.size() <= 2) {
            return possible.get(0);
        }
        List<Integer> nextGuess = possible;
        int guessIndex = -1;

        for (int guess = 0; guess < h.length; guess++) {

            if (path.contains(guess)) {
                continue;
            }

            List<Integer>[] groups = new ArrayList[7];
            for (int i = 0; i < 7; ++i) groups[i] = new ArrayList<Integer>();
            for (Integer j: possible) {
                if (j != guess) {
                    groups[h[guess][j]].add(j);
                }
            }

            List<Integer> maxGroup = groups[0];
            for (int i = 0; i < 7; ++i) {
                if (groups[i].size() > maxGroup.size()) {
                    maxGroup = groups[i];
                }
            }

            if (maxGroup.size() < nextGuess.size()) {
                nextGuess = maxGroup;
                guessIndex = guess;
            }

        }

        return guessIndex;
    }

}


