package com.potato.study.leetcode.p0403;


import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         403. Frog Jump
 * 
 *       A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping
1 unit to the 2nd stone, then 2 units to the 3rd stone, then
2 units to the 4th stone, then 3 units to the 6th stone,
4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as
the gap between the 5th and 6th stone is too large.
 * 
 * 
 *         思路：
 *         简单易懂的代码
 *         https://segmentfault.com/a/1190000016948142
 *
 *         使用map 保存 石头节点 key 石头位置 value 从该点出发，能走多少步
 *         初始化 在 0号石头中 增加可以走1步的设置
 *
 *         遍历石头，对于每个石头 currentStonePos 从map中获取到 下一步可以走的 step 数 set
 *
 *         对于每个step 判断 currentStonePos + step 是否属于map （是否有石头），
 *         有的话 可以将 step -1 ，step + 1，step 加入到 currentStonePos + step为key的map值中
 *
 *         如果 currentStonePos + step == 最后一个石头 直接返回 true吧
 *
 * 
 */
public class Solution {

    public boolean canCross(int[] stones) {
        // 0. 使用map 保存 石头节点 key 石头位置 value 从该点出发，能走多少步
        Map<Integer, Set<Integer>> stepsFromThisStone = new HashMap<>();
        for (int stone : stones) {
            stepsFromThisStone.put(stone, new HashSet<>());
        }
        // 0.1 初始化 在 0号石头中 增加可以走1步的设置 must have 0
        stepsFromThisStone.get(0).add(1);
        // 1. 遍历石头，对于每个石头 currentStonePos 从map中获取到 下一步可以走的 step数 set
        for (int currentStonePos : stones) {
            Set<Integer> nextSteps = stepsFromThisStone.get(currentStonePos);
            for (int step : nextSteps) {
                // 对于每个step 判断 currentStonePos + step 是否属于map （是否有石头）
                int nextStone = currentStonePos + step;
                Set<Integer> tmpNextStepSet = stepsFromThisStone.get(nextStone);
                if (null != tmpNextStepSet) {
                    if (step - 1 > 0) {
                        tmpNextStepSet.add(step - 1);
                    }
                    tmpNextStepSet.add(step);
                    tmpNextStepSet.add(step + 1);
                }
                if (currentStonePos + step == stones[stones.length - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] stones = {0,1,3,5,6,8,12,17};
		boolean canCross = solution.canCross(stones);
		System.out.println(canCross);
        Assert.assertEquals(true, canCross);


        int[] stones1 = {0,1,2,3,4,8,9,11};
        canCross = solution.canCross(stones1);
        System.out.println(canCross);
        Assert.assertEquals(false, canCross);
    }
}
