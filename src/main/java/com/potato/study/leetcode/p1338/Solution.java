package com.potato.study.leetcode.p1338;



import org.junit.Assert;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1338. Reduce Array Size to The Half
 *  
 *
Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.



Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
Example 3:

Input: arr = [1,9]
Output: 1
Example 4:

Input: arr = [1000,1000,3,7]
Output: 1
Example 5:

Input: arr = [1,2,3,4,5,6,7,8,9,10]
Output: 5


Constraints:

1 <= arr.length <= 10^5
arr.length is even.
1 <= arr[i] <= 10^5
 *         
 *         思路：
 *
 *         找到最少的 set 使得 按照 set去删除 数字可以使得 数组中的值最小
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    public int minSetSize(int[] arr) {

        // 有序 map 按照出现次数有大到小排序 遍历map 减去数量 知道 剩余数量小于 一般
        int len = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer times = countMap.getOrDefault(arr[i], 0);
            times++;
            countMap.put(arr[i], times);
        }
        // 堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> en : countMap.entrySet()) {
            priorityQueue.add(new int[]{en.getKey(), en.getValue()});
        }
        int currentLen = len;
        int minSize = 0;
        while (currentLen > len / 2) {
            int[] nums = priorityQueue.poll();
            currentLen -= nums[1];
            minSize++;
        }
        return minSize;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();


        int[] arr = new int[]{7,7,7,7,7,7};
        int res = solution.minSetSize(arr);
        System.out.println(res);
        Assert.assertEquals(1, res);

        arr = new int[]{1,9};
        res = solution.minSetSize(arr);
        System.out.println(res);
        Assert.assertEquals(1, res);

        arr = new int[]{1000,1000,3,7};
        res = solution.minSetSize(arr);
        System.out.println(res);
        Assert.assertEquals(1, res);

        arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        res = solution.minSetSize(arr);
        System.out.println(res);
        Assert.assertEquals(5, res);
    }
}
