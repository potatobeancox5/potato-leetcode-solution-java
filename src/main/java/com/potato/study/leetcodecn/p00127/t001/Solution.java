package com.potato.study.leetcodecn.p00127.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.*;

/**
 * 127. 单词接龙
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：

 序列中第一个单词是 beginWord 。
 序列中最后一个单词是 endWord 。
 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典 wordList 中的单词。
 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 如果不存在这样的转换序列，返回 0。

  
 示例 1：

 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 输出：5
 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 示例 2：

 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 输出：0
 解释：endWord "cog" 不在字典中，所以无法进行转换。
  

 提示：

 1 <= beginWord.length <= 10
 endWord.length == beginWord.length
 1 <= wordList.length <= 5000
 wordList[i].length == beginWord.length
 beginWord、endWord 和 wordList[i] 由小写英文字母组成
 beginWord != endWord
 wordList 中的所有字符串 互不相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-ladder
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 用一个 set 存储 wordList
     * 2. 判断 endWord 是不是在这个里边 如果是的话 那ok
     * 3. 类型层序遍历方式 将 beginWord 放入queue
     * 4. while queue 非空，遍历 set 找到 相差一个字母的 word 方入queue 同时从set 中删除
     * 5. 过程中 计数 层，如果在放 word 过程中 找到了 end 直接返回当前层数 + 1
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int layer = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            layer++;
            for (int i = 0; i < len; i++) {
                String poll = queue.poll();
                Iterator<String> iterator = wordSet.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    // set 中找到一个与之相差1的单词
                    if (isOnlySolitaire(poll, next)) {
                        if (endWord.equals(next)) {
                            return layer + 1;
                        } else {
                            queue.add(next);
                            iterator.remove();
                            continue;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * word2 是否 与 word1 只相差一个字母
     * true 只相差一个字母
     * false
     * @param word1
     * @param word2
     * @return
     */
    private boolean isOnlySolitaire(String word1, String word2) {
        if (null == word1 || null == word2) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        // 遍历每个位置 记录不同字母的数量
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
        List<String> wordList = Lists.newArrayList(
                "hot","dot","dog","lot","log","cog"
        );
        int res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
        Assert.assertEquals(5, res);


        beginWord = "hit";
        endWord = "cog";
        wordList = Lists.newArrayList(
                "hot","dot","dog","lot","log"
        );
        res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
        Assert.assertEquals(0, res);

        beginWord = "hit";
        endWord = "hot";
        wordList = Lists.newArrayList(
                "hot","dot","dog","lot","log"
        );
        res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }

}
