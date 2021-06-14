package com.potato.study.leetcodecn.p01338.t001;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.potato.study.leetcode.util.ArrayUtil;
import com.potato.study.leetcode.util.LeetcodeInputUtils;

/**
 * 1338. 数组大小减半
 *
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 *
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * 示例 2：
 *
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * 示例 3：
 *
 * 输入：arr = [1,9]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 * 示例 5：
 *
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reduce-array-size-to-the-half
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *直接对 arr 中出现的数字进行计数
     *
     * 然后 从 计数最多的那个开始，删除 直到 删除的数字达到了 之前的一半即可
     * @param arr
     * @return
     */
    public int minSetSize(int[] arr) {
        int totalNum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
            totalNum++;
        }
        // 一半是多少
        int half = (totalNum + 1) / 2;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int tmp = 0;
        int sizeCount = 0;
        while (tmp < half && !priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            tmp += poll[1];
            sizeCount++;
        }
        return sizeCount;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String input = "[[3,3,1,1],[2,2,1,2],[1,1,1,2]]";
//        int[][] array = LeetcodeInputUtils.inputString2IntArrayTwoDimensional(input);
//        int[][] res = solution.diagonalSort(array);
//        // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//        ArrayUtil.printMatrix(res);
//    }
}
