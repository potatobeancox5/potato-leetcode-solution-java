package com.potato.study.leetcode.p1046;


import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1046. Last Stone Weight
 *  
 *        We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
 *         
 *
 *         题目含义：
 *          大根堆
 *
 *
 *
 */
public class Solution {


    public int lastStoneWeight(int[] stones) {

        if (null == stones) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() >= 2) {
            Integer stone1 = priorityQueue.poll();
            Integer stone2 = priorityQueue.poll();

            if (stone1 == stone2) {
                continue;
            }
            priorityQueue.add(Math.abs(stone1 - stone2));
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        }
        return priorityQueue.poll();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] stones = new int[]{2,7,4,1,8,1};
        int weight = solution.lastStoneWeight(stones);
        System.out.println(weight);
        Assert.assertEquals(1, weight);
    }
}
