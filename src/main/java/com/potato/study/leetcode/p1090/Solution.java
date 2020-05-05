package com.potato.study.leetcode.p1090;


import org.junit.Assert;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1090. Largest Values From Labels
 *  
 *       We have a set of items: the i-th item has value values[i] and label labels[i].

Then, we choose a subset S of these items, such that:

|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S.



Example 1:

Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Explanation: The subset chosen is the first, third, and fifth item.
Example 2:

Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12
Explanation: The subset chosen is the first, second, and third item.
Example 3:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16
Explanation: The subset chosen is the first and fourth item.
Example 4:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24
Explanation: The subset chosen is the first, second, and fourth item.


Note:

1 <= values.length == labels.length <= 20000
0 <= values[i], labels[i] <= 20000
1 <= num_wanted, use_limit <= values.length
 *         
 *
 *
 *
 *         思路：
 *          按照 value 排序 选择大的 map 维护 label count
 *
 *
 */
public class Solution {

    /**
     *
     * @param values
     * @param labels
     * @param numWanted values 中最多选择 numWanted个
     * @param useLimit  每个标签最多有 useLimit 个
     * @return
     */
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < values.length; i++) {
            priorityQueue.add(new int[]{values[i], labels[i]});
        }
        Map<Integer, Integer> labelCount = new HashMap<>();
        int sum = 0;
        while (numWanted > 0 && !priorityQueue.isEmpty()) {
            int[] num = priorityQueue.poll();
            Integer count = labelCount.getOrDefault(num[1], 0);
            if (count < useLimit) {
                sum += num[0];
                count++;
                labelCount.put(num[1], count);
                numWanted--;
            }
        }
        return sum;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] values = new int[]{5,4,3,2,1};
        int[] labels = new int[]{1,1,2,2,3};
        int numWanted = 3;
        int useLimit = 1;
        int num = solution.largestValsFromLabels(values, labels, numWanted, useLimit);
        System.out.println(num); // ["ac","ad","ae","bc","bd","be"]
        Assert.assertEquals(9, num);
    }
}
