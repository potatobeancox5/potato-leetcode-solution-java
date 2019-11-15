package com.potato.study.leetcode.p0517;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         517. Super Washing Machines
 * 
 *         You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.

For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .

Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.

Example1

Input: [1,0,5]

Output: 3

Explanation:
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3
3rd move:    2     1 <-- 3    =>    2     2     2
Example2

Input: [0,3,0]

Output: 2

Explanation:
1st move:    0 <-- 3     0    =>    1     2     0
2nd move:    1     2 --> 0    =>    1     1     1
Example3

Input: [0,2,0]

Output: -1

Explanation:
It's impossible to make all the three washing machines have the same number of dresses.
Note:
The range of n is [1, 10000].
The range of dresses number in a super washing machine is [0, 1e5].

 * 
 * 
 *         思路：
 *         517. Super Washing Machines

https://blog.csdn.net/lihuixuaaa/article/details/78160891

本质是求 每个最为移动最多的绝对值

1 计算出target 即平均值

2 遍历数组 通过balance记录之前传过来多少 或者需要传多少
计算本位置的变动量
balance +=  num i 减去target

minstep 等于 max｛minstep abs balance num i 减去tarhet｝

3  求最大的变动量

更好的解释

https://www.jianshu.com/p/d9433998e26e
历史移动 本次移动  比较出至少移动数
 *
 *          
 */
public class Solution {

    public int findMinMoves(int[] machines) {
        // 1 计算出target 即平均值
        int sum = 0;
        for (int machineCount : machines) {
            sum += machineCount;
        }
        int size = machines.length;
        if (sum % size != 0) {
            return -1;
        }
        int ave = sum / size;
        int minStep = 0;
        // 记录上个位置需要往这个位置 传或者取衣服的件数
        int balance = 0;
        // 2 遍历数组 通过balance记录之前传过来多少 或者需要传多少
        for (int i = 0; i < machines.length; i++) {
            // 计算本位置的变动量
            balance += (machines[i] - ave);
//        minstep 等于 max｛minstep abs balance num i 减去tarhet｝
            minStep = Math.max(minStep, Math.max(Math.abs(balance), machines[i] - ave));
        }
        return minStep;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] machines = {1,0,5};
        int findMinMoves = solution.findMinMoves(machines);
        System.out.println(findMinMoves);
        Assert.assertEquals(3, findMinMoves);
    }
}
