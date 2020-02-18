package com.potato.study.leetcode.p0756;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	756. Pyramid Transition Matrix
 *  
 *         We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.

We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:

Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
A
/ \
G   E
/ \ / \
B   C   D

We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.


Example 2:

Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.


Note:

bottom will be a string with length in range [2, 8].
allowed will have length in range [0, 200].
Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.


 *   题目含义：
 *      每个字符串 含有3个字母 最后一个字母 代表可以作为顶点的点 其他是它的底座
 *      问 给出的bottom 是否可以堆积成一个金字塔形状的东西
 *      https://blog.csdn.net/qq_25026989/article/details/89198631
 *
 * 
 */
public class Solution {


    public boolean pyramidTransition(String bottom, List<String> allowed) {
        List<Character> currentLayer = new ArrayList<>();
        for (char ch : bottom.toCharArray()) {
            currentLayer.add(ch);
        }
        List<Character> nextLayer = new ArrayList<>();
        Map<String, List<Character>> map = new HashMap<>();
        for (String str : allowed) {
            String bot = str.substring(0, 2);
            char top = str.charAt(2);
            List<Character> topList = map.getOrDefault(bot, new ArrayList<>());
            topList.add(top);
            map.put(bot, topList);
        }
        return backtrack(0, currentLayer, nextLayer, map);
    }

    /**
     *
     * @param index 当前开始找的位置
     * @param currentLayer  当前底座
     * @param nextLayer     构造的下一层节点
     * @param map           底部 对应 top的关系
     * @return
     */
    private boolean backtrack(int index, List<Character> currentLayer, List<Character> nextLayer,
                         Map<String, List<Character>> map) {
        // 达到最后一个点 终止条件
        if (index == currentLayer.size() - 1) {
            // 本层最后一节节点时 next 只有一个点 说明已经是一个金字塔了
            if (nextLayer.size() == 1) {
                return true;
            }
            // 从头开始找 下一层
            currentLayer = nextLayer;
            nextLayer = new ArrayList<>();
            index = 0;
        }
        // 获取本次判读的底部
        String rootStr = "" + currentLayer.get(index) + currentLayer.get(index + 1);
        List<Character> topStrs = map.get(rootStr);
        if (null == topStrs) {
            return false;
        }
        // 依次找到本次的底部对应的top 递归查找
        for (Character top : topStrs) {
            nextLayer.add(top);
            if (backtrack(index+1, currentLayer, nextLayer, map)) {
                return true;
            }
            nextLayer.remove(nextLayer.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String bottom = "BCD";
        List<String> allowed = Arrays.asList(new String[]{"BCG", "CDE", "GEA", "FFF"});
        boolean res = solution.pyramidTransition(bottom, allowed);
        System.out.println("res:" + res);
        Assert.assertEquals(true, res);

        bottom = "AABA";
        allowed = Arrays.asList(new String[]{"AAA", "AAB", "ABA", "ABB", "BAC"});
        res = solution.pyramidTransition(bottom, allowed);
        System.out.println("res:" + res);
        Assert.assertEquals(false, res);
    }
}
