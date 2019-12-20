package com.potato.study.leetcode.p0632;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *         632. Smallest Range Covering Elements from K Lists
 * 
 *         You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.



Example 1:

Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].


Note:

The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
 *
 * 	思路：
 *
 * 	    632. Smallest Range Covering Elements from K Lists

https://blog.csdn.net/huanghanqian/article/details/74765018

用堆存储 index 实际value
index 是 list标号 value 是该标号实际值
小跟堆 按照value 排序

先把所有0位置入堆
计算max

找到最小的index 出队
计算max-出队值

入队 入队时修改max



最后得到最小的max -min 就是最小范围

https://blog.csdn.net/huanghanqian/article/details/74765018
 *
 */
public class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        // 1. 队列数
        int n = nums.size();
        // 用堆存储 index 实际value 0 是list index          1 是value  2是list 中的index
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 2. 先把所有0位置入堆
        int max = Integer.MIN_VALUE;
        long finalMin = Integer.MIN_VALUE;
        long finalMax = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            priorityQueue.add(new int[]{i, val, 0});
        }
        // 3. 依次出堆 记录 每次的max和min
        while (!priorityQueue.isEmpty()) {
            int[] target = priorityQueue.poll();
            int val = target[1];
            int listIndex = target[0];
            int innerIndex = target[2];

            if (max - val < finalMax - finalMin) {
                finalMax = max;
                finalMin = val;
            }

            innerIndex++;
            // 已经到达了这个list的极限，break吧
            if (innerIndex == nums.get(listIndex).size()) {
                break;
            }
            // 获取新值 放到队列中
            Integer newValue = nums.get(listIndex).get(innerIndex);
            priorityQueue.add(new int[]{listIndex, newValue, innerIndex});
            // 添加时 修改 并记录max
            max = Math.max(max, newValue);
        }
        return new int[]{(int)finalMin, (int)finalMax};
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        List<List<Integer>> nums = null;
		int[] res = solution.smallestRange(nums);
		System.out.println(Arrays.toString(res)); // 20,24
	}
}
