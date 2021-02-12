package com.potato.study.leetcodecn.p01122.t001;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，

 arr2 中的元素各不相同
 arr2 中的每个元素都出现在 arr1 中
 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

  

 示例：

 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 输出：[2,2,2,1,4,3,3,9,6,7,19]
  

 提示：

 1 <= arr1.length, arr2.length <= 1000
 0 <= arr1[i], arr2[i] <= 1000
 arr2 中的元素 arr2[i] 各不相同
 arr2 中的每个元素 arr2[i] 都出现在 arr1 中

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/relative-sort-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计数排序 对 arr1 出现数字进行计数
     * 然后 遍历2 重新成成 arr1
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
        }
        int index = 0;
        for (int num : arr2) {
            // 题目保证一定有
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                arr1[index++] = num;
            }
            countMap.remove(num);
        }
        // 最终的位置如何 未出现的升序排列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (Map.Entry<Integer, Integer> entry :countMap.entrySet()) {
            priorityQueue.add(new int[] {entry.getKey(), entry.getValue()});
        }
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            for (int i = 0; i < poll[1]; i++) {
                arr1[index++] = poll[0];
            }
        }
        return arr1;
    }


//    public static void main(String[] args) {
//        double ss = 970 / 100.0;
//        System.out.println((long)(ss * 100));
//    }
}
