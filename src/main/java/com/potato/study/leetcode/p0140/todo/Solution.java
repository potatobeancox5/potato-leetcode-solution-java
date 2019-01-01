package com.potato.study.leetcode.p0140.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *        140. Word Break II
 *         
 *         Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
"cats and dog",
"cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
"pine apple pen apple",
"pineapple pen apple",
"pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
  
 *         思路：DP+DFS
 *         第一步
 *         dp[i] = {1,2,3} 记录从0到 i 节点（不包括）的字符串 ，可以从哪里断开
 *         也就是说 0 到 i 的字符串 可以从k进行断开 保证 0到k有值 且 k~i 字符串是wordDict 包含的
 *         第二步从后向前访问dp[i-1] 根据其中的值 往前访问 直到遇到的列表为空
 *
 *         https://blog.csdn.net/tingting256/article/details/50381832
 *
 *
 *
 *
 */
public class Solution {

	public List<String> wordBreak(String s, List<String> wordDict) {
        //1 .dp查找下一个开始的点
        Set<String> wordDictSet = convertWordDict2Set(wordDict);
        List[] dpArray = buildWordBreakDp(s, wordDictSet);
        //2. 搜索dp 构造结果
        List<String> result = new ArrayList<>();

        if (dpArray[s.length() - 1].size() > 0) {
            return buildWordBreakResult(dpArray, s.length() - 1, s, result);
        } else {
            if (wordDict.contains(s)) {
                List<String> singleResult = new ArrayList<>();
                singleResult.add(s);
                return singleResult;
            }
            return new ArrayList<>();
        }
//        return buildWordBreakResult(dpArray, s.length() - 1, s, result);
	}

    /**
     * 转换对象
     * @param wordDict
     * @return
     */
    private Set<String> convertWordDict2Set (List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        return set;
    }

    /**
     * 构造dp数组
     * @param s
     * @param wordDict
     * @return
     */
	private List[] buildWordBreakDp (String s, Set<String> wordDict) {
        List<Integer>[] dpArray = new List[s.length()];
        // 初始化dpArray
        for (int i = 0; i < dpArray.length; i++) {
            dpArray[i] = new ArrayList<>();
        }
        // 生成dp数组
        for (int i = 0; i < s.length(); i++) { // 0 到 len - 1 遍历
            for (int j = 0; j <= i; j++) {
                // 添加index的两个条件 1.dp[j-1].lem > 0 且 subStr（j, i+1） 属于worddic || j == 0 j ~i+1属于worddic
                if ((j == 0 && wordDict.contains(s.substring(j, i+1)))
                        || (j > 0 && dpArray[j-1].size() > 0 && wordDict.contains(s.substring(j, i+1)))) {
                    dpArray[i].add(j - 1);
                }
            }
        }
        return dpArray;
    }

    /**
     * 通过深度优先搜索 dpArr
     * @param dpArr
     * @return
     */
    private List<String> buildWordBreakResult(List[] dpArr, int currentIndex, String s, List<String> resultList) {

        List<String> totalList = new ArrayList<>();

        List<Integer> preIndexList = dpArr[currentIndex];
        if (null == preIndexList || preIndexList.size() == 0) {
            return resultList;
        }
//        else if (preIndexList.size() == 1 && preIndexList.get(0) == -1) {
//            resultList.add(s.substring(0, currentIndex + 1));
//            return resultList;
//        }
        // 遍历数组 生成当前字符串
        for (Integer preIndex : preIndexList) {
            String word = s.substring(preIndex + 1, currentIndex + 1);
            List<String> newResult = new ArrayList<>();
            if (resultList.size() == 0) {
                newResult.add(word);
            } else {
                for (String resultSuffix : resultList) {
                    newResult.add(word + " " + resultSuffix);
                }
            }
            if (preIndex == -1) {
                totalList.addAll(newResult);
            } else {
                totalList.addAll(buildWordBreakResult(dpArr, preIndex, s, newResult));
            }
        }
        return totalList;
    }



	
	public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
//        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

//        String s = "ab";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("a");
//        wordDict.add("b");

        List<String> list = solution.wordBreak(s, wordDict);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
