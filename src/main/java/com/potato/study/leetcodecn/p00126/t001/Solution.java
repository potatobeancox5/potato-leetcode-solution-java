package com.potato.study.leetcodecn.p00126.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.*;

/**
 * 126. 单词接龙 II
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换后得到的单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回一个空列表。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 示例 1:

 输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 输出:
 [
 ["hit","hot","dot","dog","cog"],
   ["hit","hot","lot","log","cog"]
 ]
 示例 2:

 输入:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 输出: []

 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-ladder-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private List<List<String>> resultList;

    private int maxPathLength;

    /**
     * 递归处理 记录一个全局最最小值 和 全局结果
     * @param beginWord 开始单词
     * @param endWord   结束单词
     * @param wordList  单词列表
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.resultList = new ArrayList<>();
        this.maxPathLength = Integer.MAX_VALUE;
        // 预处理一下
        Map<String, Set<String>> connectMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (isSolitaire(beginWord, wordList.get(i))) {
                Set<String> set = connectMap.getOrDefault(beginWord, new HashSet<>());
                set.add(wordList.get(i));
                connectMap.put(beginWord, set);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isSolitaire(wordList.get(i), wordList.get(j))) {
                    Set<String> set1 = connectMap.getOrDefault(wordList.get(i), new HashSet<>());
                    set1.add(wordList.get(j));
                    connectMap.put(wordList.get(i), set1);
                    Set<String> set2 = connectMap.getOrDefault(wordList.get(j), new HashSet<>());
                    set2.add(wordList.get(i));
                    connectMap.put(wordList.get(j), set2);
                }
            }
        }
        boolean[] usedStatus = new boolean[wordList.size()];
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        getLadders(beginWord, endWord, wordList, usedStatus, path, connectMap);
        return resultList;
    }


    /**
     * dfs 找最小
     * @param current
     * @param target
     * @param wordList
     * @param usedStatus
     * @param path 走到 current 的路径 ，其中包括 current
     */
    private void getLadders(String current, String target, List<String> wordList, boolean[] usedStatus,
            List<String> path, Map<String, Set<String>> connectMap) {
        // 终止条件 如果当前 current 就是 target 比较一下 是否最小的path
        if (target.equals(current)) {
            if (path.size() == maxPathLength) {
                resultList.add(path);
            } else if (path.size() < maxPathLength) {
                resultList = new ArrayList<>();
                resultList.add(path);
                maxPathLength = path.size();
            }
            return;
        }
        // 修改 current 对应 遍历 wordlist 如果 uesd contonue 否则 生成 新path 然后递归调用
        for (int i = 0; i < wordList.size(); i++) {
            // 之前用过
            if (usedStatus[i]) {
                continue;
            }
            // 预处理优化判定是否链接
            Set<String> containSet = connectMap.get(current);
            if (containSet == null) {
                continue;
            }
            if (!containSet.contains(wordList.get(i))) {
                continue;
            }
            // word i 需要被使用
            String word = wordList.get(i);
            usedStatus[i] = true;
            List<String> newPath = new ArrayList<>(path);
            newPath.add(word);
            getLadders(word, target, wordList, usedStatus, newPath, connectMap);
            usedStatus[i] = false;
        }
    }

    /**
     * 两个单词是不是接龙关系
     * @param word1
     * @param word2
     * @return
     */
    private boolean isSolitaire(String word1, String word2) {
        if (null == word1 || word2 == null) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Lists.newArrayList("hot","dot","dog","lot","log","cog");
        List<List<String>> ladders = solution.findLadders(beginWord, endWord, wordList);
        // ["hit","hot","dot","dog","cog"],
        // ["hit","hot","lot","log","cog"]
        System.out.println(ladders);


        beginWord = "red";
        endWord = "tax";
        wordList = Lists.newArrayList("ted","tex","red","tax","tad","den","rex","pee");
        ladders = solution.findLadders(beginWord, endWord, wordList);
        // [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
        System.out.println(ladders);
    }
}
