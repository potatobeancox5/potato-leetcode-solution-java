package com.potato.study.leetcode.p1217;


import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1217. Play with Chips
 *  
 *There are some chips, and the i-th chip is at position chips[i].

You can perform any of the two following types of moves any number of times (possibly zero) on any chip:

Move the i-th chip by 2 units to the left or to the right with a cost of 0.
Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
There can be two or more chips at the same position initially.

Return the minimum cost needed to move all the chips to the same position (any position).



Example 1:

Input: chips = [1,2,3]
Output: 1
Explanation: Second chip will be moved to positon 3 with cost 1. First chip will be moved to position 3 with cost 0. Total cost is 1.
Example 2:

Input: chips = [2,2,2,3,3]
Output: 2
Explanation: Both fourth and fifth chip will be moved to position two with cost 1. Total minimum cost will be 2.


Constraints:

1 <= chips.length <= 100
1 <= chips[i] <= 10^9
 *         
 *         思路：
 *         将所有 chip 移动到同一个位置的代价
 *         因为移动2step 代价为 0 那么 奇数位置和偶数位置 都已经在一起了
 *
 *         那么就是求奇数或者偶数个数最小值
 *
 *         https://blog.csdn.net/shiliang97/article/details/102527525
 *
 *
 *
 *
 */
public class Solution {

    public int minCostToMoveChips(int[] chips) {

        int oddNum = 0;
        int evenNum = 0;

        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                evenNum++;
            } else {
                oddNum++;
            }
        }
        return oddNum > evenNum ? evenNum : oddNum;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] chips = new int[]{1,2,3};
        int res = solution.minCostToMoveChips(chips);
        System.out.println(res);
        Assert.assertEquals(1, res);

        chips = new int[]{2,2,2,3,3};
        res = solution.minCostToMoveChips(chips);
        System.out.println(res);
        Assert.assertEquals(2, res);

    }
}
