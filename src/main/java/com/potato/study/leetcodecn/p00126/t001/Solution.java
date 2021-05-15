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

    /**
     * 根 127 一致 只不过需要找到所有的最短转换序列，而且要输出序列 这里如何记录序列是个难点
     * 那我们维护一个 map 记录从开始位置 key 位置 走过的最短序列结果集合，这样 每次找下一个节点的时候 都能生成对应的店
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<List<String>> result = new HashSet<>();
        if (null == wordList || wordList.size() == 0) {
            return new ArrayList<>();
        }
        // 1. wordList -> wordSet
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        // 2. contians end word 判断
        if (!set.contains(endWord)) {
            return new ArrayList<>();
        }
        // 3. 层序遍历 并记录 位置 每轮找到后 记录一个状态 之后就那么经过这轮之后就不再继续了
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean hasFound = false;
        Map<String, Set<List<String>>> resultMap = new HashMap<>();
        Set<List<String>> list = new HashSet<>();
        List<String> innerList = new ArrayList<>();
        innerList.add(beginWord);
        list.add(innerList);
        resultMap.put(beginWord, list);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                // 遍历 set
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (isSolitaire(poll, next)) {
                        // 组装结果
                        Set<List<String>> keyPath = resultMap.getOrDefault(next, new HashSet<>());
                        Set<List<String>> lastPath = resultMap.get(poll);
                        for (List<String> eachPath : lastPath) {
                            List<String> newList = new ArrayList<>(eachPath);
                            newList.add(next);
                            keyPath.add(newList);
                        }
                        if (endWord.equals(next)) {
                            // 找到
                            hasFound = true;
                            // 组装结果 遍历当前结果
                            Set<List<String>> resultList = resultMap.getOrDefault(endWord, new HashSet<>());
                            resultList.addAll(keyPath);
                            resultMap.put(next, resultList);
                        } else {
                            resultMap.put(next, keyPath);
                            queue.add(next);
                            iterator.remove();
                        }
                    }
                }
            }
            // 当前层已经确定了答案直接跳出
            if (hasFound) {
                break;
            }
        }
        result = resultMap.get(endWord);
        if (result == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(result);
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
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Lists.newArrayList("hot","dot","dog","lot","log","cog");
        List<List<String>> ladders = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }
}
