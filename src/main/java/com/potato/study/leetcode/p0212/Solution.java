package com.potato.study.leetcode.p0212;

import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         212. Word Search II
 * 
 * 			Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
words = ["oath","pea","eat","rain"] and board =
[
['o','a','a','n'],
['e','t','a','e'],
['i','h','k','r'],
['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.


    题目需求：

    思路：
        从每个节点开始深度优先搜索
        dfs 实现用一个数组 记录 访问状态
        每次拿当前数组值去pretie去比较 前缀树包含这个结点 往下继续走

        https://www.jianshu.com/p/e1bf6aca0344
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        return null;
    }
}
