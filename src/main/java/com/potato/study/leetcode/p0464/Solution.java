package com.potato.study.leetcode.p0464;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         464. Can I Win
 * 
 *         In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.

 * 
 * 
 *         思路：
 *         464. Can I Win

https://blog.csdn.net/liuchuo/article/details/54729227

//maxchoose 大于 target true
//如果 项数总和小于target 怎么选当前都输
//递归执行  canwith   target   visited
//注 使用map 缓存结果 key visited value 赢or输   visited 中第i位为1代表已经访问了第i位


//canwin  target visited maxchoose
//
//for i  0 maxchoose -1
//mask  等于 1 左移位 i
//if mask 与 visited ==1 说明访问过
//continue
//生成visited tmp
//if  map 存在visited 直接返回结果
//否则
//if i 》= target 或者 ！canwin target-i  tmp maxchoose
//map记录
//return true
//
//
//end for
//map记录
//返回flase
 *
 * 				
 */	
public class Solution {

    /**
     * 缓存结果 key 是当前遍历到的数字的记录，value 是当前结果
     */
    private Map<Integer, Boolean> resMap = new HashMap();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //        maxchoose 大于 target true
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        //如果 项数总和小于target 怎么选当前都输
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        //递归执行  canwith   target   visited
        int visited = 0; // 每一个位置代表一个数字，如果为1 代表已经遍历过了
        return canWin(desiredTotal, visited, maxChoosableInteger);
    }


    /**
     *
     * @param desiredTotal      要达到的值
     * @param visited           已经遍历的数字记录
     * @param maxChoosableInteger   最大能选择的数字
     * @return
     */
    private boolean canWin(int desiredTotal, int visited, int maxChoosableInteger) {
        // i 代表需要进行移位的次数
        for (int i = 0; i < maxChoosableInteger; i++) {
            //mask  等于 1 左移位 i
            int mask = (1 << i);
            //if mask 与 visited ==1 说明访问过
            if ((mask & visited) > 0) {
                continue;
            }
            //生成visited tmp
            int tmpVisited = mask | visited;
            //if  map 存在visited 直接返回结果
            if (resMap.containsKey(tmpVisited)) {
                return resMap.get(tmpVisited);
            }
            //if i 》= target 或者 ！canwin target-i  tmp maxchoose
            if (i + 1 >= desiredTotal || !canWin(desiredTotal - i - 1, tmpVisited, maxChoosableInteger)) {
                resMap.put(tmpVisited, true);
                return true;
            }
        }
        resMap.put(visited, false);
        return false;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean res = solution.canIWin(10, 11);
		System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
