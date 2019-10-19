package com.potato.study.leetcode.p0488;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         488. Zuma Game
 * 
 *        Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.

Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.

Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.

Examples:

Input: "WRRBBW", "RB"
Output: -1
Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

Input: "WWRRBBWW", "WRBRW"
Output: 2
Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

Input:"G", "GGGGG"
Output: 2
Explanation: G -> G[G] -> GG[G] -> empty

Input: "RBYYBBRRB", "YRBGB"
Output: 3
Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty

Note:
You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 * 
 *         思路：
 *         https://blog.csdn.net/xdhc304/article/details/79374908
 *         思想 对每个移除的字符串进行移除
 *
 *         
 * 
 */
public class Solution {

    public int findMinStep(String board, String hand) {
        // 1. 统计手中的字符个数
        int[] chNum = new int[26];
        for (char ch : hand.toCharArray()) {
            chNum[ch - 'A']++;
        }

        // 2. 获取结果 ，内部回溯法实现 末尾加 # 方便判断
        int minStep = getMinStep(board + "#", chNum);
        if (minStep > 5) {
            return -1;
        }
        return minStep;
    }


    /**
     * 回溯法 获取消除s 的最小步骤
     * @param s
     * @param charCount
     * @return
     */
    private int getMinStep(String s, int[] charCount) {
        // 进来的时候就要先消除一下，因为有可能组装的时候造成了3消除的场景
        s = removeThribleCharactors(s);
        // 对s 进行遍历，每次消除其中一种字符，然后将消除后的串再进行判断
        if ("#".equals(s)) {
            return 0;
        }
        int i = 0;
        int minSteps = 6;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i)) {
                continue;
            }
            int needPopCount = 3 - (j - i);
            char ch = s.charAt(i);
            if (charCount[ch - 'A'] >= needPopCount) {
                charCount[ch - 'A'] -= needPopCount;
                // 回溯的逻辑 将这个字符串干掉
                minSteps = Math.min(minSteps, getMinStep(s.substring(0, i) + s.substring(j), charCount) + needPopCount);
                charCount[ch - 'A'] += needPopCount;
            }
            i = j;
        }
        return minSteps;
    }


    /**
     * 删除 target 中所有的3连字符串
     * @param target
     * @return
     */
    private String removeThribleCharactors(String target) {
        int i = 0;
        for (int j = 0; j < target.length(); j++) {
            if (target.charAt(j) == target.charAt(i)) {
                continue;
            }
            // bigger than 3
            if (j - i >= 3) {
                return removeThribleCharactors(target.substring(0, i) + target.substring(j));
            }
            i = j;
        }
        return target;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String board = "WRRBBW";
		String hand = "RB";
        int minStep = solution.findMinStep(board, hand);
        System.out.println(minStep);
        Assert.assertEquals(-1, minStep);

        board = "WWRRBBWW";
        hand = "WRBRW";
        minStep = solution.findMinStep(board, hand);
        System.out.println(minStep);
        Assert.assertEquals(2, minStep);

        board = "G";
        hand = "GGGGG";
        minStep = solution.findMinStep(board, hand);
        System.out.println(minStep);
        Assert.assertEquals(2, minStep);

        board = "RBYYBBRRB";
        hand = "YRBGB";
        minStep = solution.findMinStep(board, hand);
        System.out.println(minStep);
        Assert.assertEquals(3, minStep);
    }
}
