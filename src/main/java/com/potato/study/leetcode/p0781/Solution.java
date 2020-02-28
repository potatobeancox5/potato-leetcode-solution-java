package com.potato.study.leetcode.p0781;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	781. Rabbits in Forest
 *  
 *         In a forest, each rabbit has some color.
 *         Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them.
 *         Those answers are placed in an array.

Return the minimum number of rabbits that could be in the forest.

Examples:
Input: answers = [1, 1, 2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit than answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

Input: answers = [10, 10, 10]
Output: 11

Input: answers = []
Output: 0
Note:

answers will have length at most 1000.
Each answers[i] will be an integer in the range [0, 999].
 *         
 *         思路：
 *         一样的数字整合 然后 + 1
 *
 *         https://blog.csdn.net/weixin_37870009/article/details/79371733
 *
 *         map 计数器 key 喊出的数字 value 出现次数
 *
 *         遍历map
 *          if 出现次数 % （喊出数字 + 1） == 0
 *              ans += 出现次数 / ( 喊出数字 + 1) * ( 喊出数字 + 1)
 *
 *          else
 *              ans = (出现次数 % （喊出数字 + 1）+ 组数) * ( 喊出数字 + 1)
 *
 *
 * 
 */
public class Solution {

    public int numRabbits(int[] answers) {

        Map<Integer, Integer> ansCountMap = new HashMap<>();
        // 统计喊出数字出现次数
        for (int ans : answers) {
            Integer count = ansCountMap.getOrDefault(ans, 0);
            ansCountMap.put(ans, count + 1);
        }
        // 根据次数 算出总计有多少个
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: ansCountMap.entrySet()) {
            int singleCount = entry.getKey() + 1;
            int countNum = entry.getValue();
            int groupNum = countNum / singleCount;
            if (countNum % singleCount == 0) {
                sum += countNum;
            } else {
                sum += (groupNum + 1) * singleCount;
            }
        }

        return sum;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();


        int[] answers = new int[]{1, 1, 2};
        int res = solution.numRabbits(answers);
        System.out.println(res);
        Assert.assertEquals(5, res);

        answers = new int[]{10, 10, 10};
        res = solution.numRabbits(answers);
        System.out.println(res);
        Assert.assertEquals(11, res);

        answers = new int[]{};
        res = solution.numRabbits(answers);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
