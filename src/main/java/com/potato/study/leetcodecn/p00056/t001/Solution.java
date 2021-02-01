package com.potato.study.leetcodecn.p00056.t001;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

  

 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：

 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
  

 提示：

 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-intervals
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 0120 合并区间
     小根堆 区间依次放进去

     i0 pop 第一个点

     while 堆非空
     next  pop
     如果 next 和 i0 重合
     重设置i0 合并
     如果不重合
     i0 记录 i0设为next

     最后 剩余加入


     判断重合
     i2 0 位于 i1 之间

     合并
     返回 min 0位置 返回max 1位置
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 1. 小根堆 区间依次放进去 首元素
        if (null == intervals || intervals.length <= 1) {
            return intervals;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            priorityQueue.add(interval);
        }
        // 2. 弹出第一个栈
        List<int[]> resultList = new ArrayList<>();
        int[] node = priorityQueue.poll();
        // 3. 依次pop 栈顶，进行合并，如果当前无法合并，将之前的区间 插入list
        while (!priorityQueue.isEmpty()) {
            int[] target = priorityQueue.poll();
            // 是否可以交叉
            if (canMerge(node, target)) {
                node = merge(node, target);
            } else {
                resultList.add(node);
                node = target;
            }
        }
        resultList.add(node);
        // 4. list -> int[]
        int[][] result = new int[resultList.size()][2];
        int i = 0;
        for (int[] interval : resultList) {
            result[i++] = interval;
        }
        return result;
    }

    /**
     * 合并两个区间
     * @param node
     * @param target
     * @return
     */
    private int[] merge(int[] node, int[] target) {
        return new int[] {Math.min(node[0], target[0]), Math.max(node[1], target[1])};
    }

    /**
     * 是否有交叉点 默认 interval1 开始值小于 interval2 开始值
     * @param interval1
     * @param interval2
     * @return
     */
    private boolean canMerge(int[] interval1, int[] interval2) {
        if (interval1[0] <= interval2[0] && interval2[0] <= interval1[1]) {
            return true;
        }
        return false;
    }
}
