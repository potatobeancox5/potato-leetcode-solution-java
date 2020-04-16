package com.potato.study.leetcode.p0895;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liuzhao11
 *
 *
 * 895. Maximum Frequency Stack
 *
 * mplement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.


Example 1:

Input:
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].


Note:

Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
The total number of FreqStack.push calls will not exceed 10000 in a single test case.
The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
 * 题目含义：
 * <p>
 *
 * 思路：
 *    1. 使用一个 map 计数
 *    2. 使用一个map 记录当前每个频率 对应的stack
 *    3. 记录当前出现的最大频率
 *    https://www.cnblogs.com/ylzylz/p/10708523.html
 *
 */
public class FreqStack {

    private Map<Integer, Integer> countMap;

    private Map<Integer, Stack<Integer>> frequencyMap;

    private int maxCount;

    public FreqStack() {
        countMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        maxCount = 0;
    }

    // 插入的时候 无脑全部插入 存在 多个值 但由于每次删除都会删掉一个其实没有影响 反而更号的支持逻辑
    public void push(int x) {
        Integer count = countMap.getOrDefault(x, 0);
        count++;
        countMap.put(x, count);

        Stack<Integer> stack = frequencyMap.getOrDefault(count, new Stack<>());
        stack.push(x);
        frequencyMap.put(count, stack);

        maxCount = Math.max(maxCount, count);

    }


    public int pop() {

        Stack<Integer> stack = frequencyMap.get(maxCount);
        // get the num
        Integer value = stack.pop();

        if (maxCount != 1) {
            countMap.put(value, maxCount - 1);
        } else {
            countMap.remove(value);
        }

        if (stack.isEmpty()) {
            frequencyMap.remove(maxCount);
            maxCount--;
        }

        return value;
    }
}
