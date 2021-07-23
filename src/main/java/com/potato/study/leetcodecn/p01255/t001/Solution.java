package com.potato.study.leetcodecn.p01255.t001;


import org.junit.Assert;

/**
 * 1255. 得分最高的单词集合
 *
 * 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
 *
 * 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
 *
 * 单词拼写游戏的规则概述如下：
 *
 * 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
 * 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
 * 单词表 words 中每个单词只能计分（使用）一次。
 * 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
 * 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,
 * 0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：23
 * 解释：
 * 字母得分为  a=1, c=9, d=5, g=3, o=2
 * 使用给定的字母表 letters，我们可以拼写单词 "dad" (5+1+5)和 "good" (3+2+2+5)，得分为 23 。
 * 而单词 "dad" 和 "dog" 只能得到 21 分。
 * 示例 2：
 *
 * 输入：words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,
 * 0,0,0,0,0,0,0,0,0,5,0,10]
 * 输出：27
 * 解释：
 * 字母得分为  a=4, b=4, c=4, x=5, z=10
 * 使用给定的字母表 letters，我们可以组成单词 "ax" (4+5)， "bx" (4+5) 和 "cx" (4+5) ，总得分为 27 。
 * 单词 "xxxz" 的得分仅为 25 。
 * 示例 3：
 *
 * 输入：words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,
 * 0,0,0,0,0]
 * 输出：0
 * 解释：
 * 字母 "e" 在字母表 letters 中只出现了一次，所以无法组成单词表 words 中的单词。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 14
 * 1 <= words[i].length <= 15
 * 1 <= letters.length <= 100
 * letters[i].length == 1
 * score.length == 26
 * 0 <= score[i] <= 10
 * words[i] 和 letters[i] 只包含小写的英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 1255
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // 将 letters 转换成 int 26 数组
        int[] letterCount = new int[26];
        for (char ch : letters) {
            letterCount[ch - 'a']++;
        }
        // 生成状态量最大值
        int limit = 1;
        limit = limit << words.length;
        // 遍历每个状态量，统计当前 状态对应数量 是否满足 letters 满足的话 计算 得分 获取最大值
        int maxScore = 0;
        for (int i = 1; i < limit; i++) {
            int[] wordCountByStatus = getWordCountByStatus(i, words);
            boolean valid = true;
            for (int j = 0; j < 26; j++) {
                if (wordCountByStatus[j] > letterCount[j]) {
                    valid = false;
                    break;
                }
            }
            // 积分
            if (valid) {
                int thisScore = getScore(wordCountByStatus, score);
                maxScore = Math.max(maxScore, thisScore);
            }
        }
        return maxScore;
    }

    private int getScore(int[] wordCount, int[] score) {
        int current = 0;
        for (int i = 0; i < 26; i++) {
            current += wordCount[i] * score[i];
        }
        return current;
    }

    /**
     * 根据状态统计次数
     * @param status
     * @param words
     * @return
     */
    private int[] getWordCountByStatus(int status, String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < words.length; i++) {
            int bit = (status & 1);
            if (bit == 0) {
                continue;
            }
            for (char ch : words[i].toCharArray()) {
                count[ch - 'a']++;
            }
            status >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {
                "dog","cat","dad","good"
        };
        char[] letters = new char[]{
                'a','a','c','d','d','d','g','o','o'
        };
        int[] score = new int[] {
                1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0
        };
        int max = solution.maxScoreWords(words, letters, score);

        Assert.assertEquals(23, max);
    }
}
