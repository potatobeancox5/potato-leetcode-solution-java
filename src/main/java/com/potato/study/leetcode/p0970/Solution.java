package com.potato.study.leetcode.p0970;

import com.potato.study.leetcode.util.ListUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	970. Powerful Integers
 *  
 *       Given two non-negative integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.

Return a list of all powerful integers that have value less than or equal to bound.

You may return the answer in any order.  In your answer, each value should occur at most once.



Example 1:

Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2
Example 2:

Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]


Note:

1 <= x <= 100
1 <= y <= 100
0 <= bound <= 10^6
 *         
 *         题目含义：
 *
 *         思路：
 *          计算两个数的n次幂 保证 <= bound
 *          遍历将结果使用set存储
 *
 *
 * 
 */
public class Solution {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> resultSet = new HashSet<>();
        List<Integer> xList = buildPowerList(x, bound);
        List<Integer> yList = buildPowerList(y, bound);
        for (int i = 0; i < xList.size(); i++) {
            for (int j = 0; j < yList.size(); j++) {
                int tmp = xList.get(i) + yList.get(j);
                if (tmp <= bound) {
                    resultSet.add(tmp);
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    /**
     * 构造小于bound 的阶乘列表
     * @param num
     * @return
     */
    private List<Integer> buildPowerList(int num, int bound) {
        List<Integer> list = new ArrayList<>();
        int temp = 1;
        list.add(temp);
        while(temp * num < bound && num > 1) {
            temp *= num;
            list.add(temp);
        }
        return list;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
		int x = 2;
		int y = 3;
		int bound = 10;
        List<Integer> list = solution.powerfulIntegers(x, y, bound);
        ListUtil.printList(list);
        x = 3;
        y = 5;
        bound = 15;
        list = solution.powerfulIntegers(x, y, bound);
        ListUtil.printList(list);
    }
}
