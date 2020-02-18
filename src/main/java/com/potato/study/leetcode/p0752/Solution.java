package com.potato.study.leetcode.p0752;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	752. Open the Lock
 *  
 *         You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.

 *   解题思路：
 *
 *   https://www.cnblogs.com/lightwindy/p/9847658.html
 *
 *   BFs 使用 * 记录每层的最终位置
 *
 *
 *
 * 
 */
public class Solution {


    public int openLock(String[] deadends, String target) {

        // 0 visited set String 判断当前数字是否已经遍历过了 queue 当前还可以进行判断的队列
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        // 最终符号
        queue.add("##");
        Set<String> block = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            String currentCode = queue.poll();
            if (target.equals(currentCode)) {
                return step;
            }

            if (block.contains(currentCode) || visited.contains(currentCode)) {
                continue;
            }
            // 可能达到了终点
            if ("##".equals(currentCode)) {
                if (queue.isEmpty()) {
                    return -1;
                } else {
                    // 还可以继续遍历
                    queue.add("##");
                    step++;
                }
            } else {
                // 其他点
                visited.add(currentCode);
                List<String> nextCodeList = this.getNextCode(currentCode);
                queue.addAll(nextCodeList);
            }
        }
        return -1;
    }


    /**
     * 获取 currentCode 密码 可以达到的后继
     * 每个数字都可以往前或者往后移动
     * @param currentCode
     * @return
     */
    public List<String> getNextCode(String currentCode) {
        List<String> codeList = new ArrayList<>();

        for (int i = 0; i < currentCode.length(); i++) {
            String prefix = currentCode.substring(0, i);
            char ch = currentCode.charAt(i);
            String suffix = currentCode.substring(i + 1);
            if ('0' == ch) {
                codeList.add(prefix + (char)(ch + 1) + suffix);
                codeList.add(prefix + '9' + suffix);
            } else if ('9' == ch) {
                codeList.add(prefix + '0' + suffix);
                codeList.add(prefix + (char)(ch - 1) + suffix);
            } else {
                codeList.add(prefix + (char)(ch + 1) + suffix);
                codeList.add(prefix + (char)(ch - 1) + suffix);
            }
        }
        return codeList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"} ;
        String target = "0202";
        int step = solution.openLock(deadends, target);
        System.out.println("count:" + step);
        Assert.assertEquals(6, step);

        deadends = new String[]{"8888"} ;
        target = "0009";
        step = solution.openLock(deadends, target);
        System.out.println("count:" + step);
        Assert.assertEquals(1, step);

        deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"} ;
        target = "8888";
        step = solution.openLock(deadends, target);
        System.out.println("count:" + step);
        Assert.assertEquals(-1, step);

        deadends = new String[]{"0000"} ;
        target = "8888";
        step = solution.openLock(deadends, target);
        System.out.println("count:" + step);
        Assert.assertEquals(-1, step);
    }
}
