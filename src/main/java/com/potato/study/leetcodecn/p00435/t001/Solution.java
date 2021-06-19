package com.potato.study.leetcodecn.p00435.t001;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;

/**
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 按照开始位置生序排序
     *
     * 遍历当前数组 如果 当前当前i与之前有重叠 移除 end 最大的
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Integer.compare(o1[0], o2[0]) == 0) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 0;
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 没有交叉
            if (hasOverlap(current, intervals[i])) {
                if (current[1] > intervals[i][1]) {
                    current = intervals[i];
                }
                count++;
                continue;
            }
            // 有交叉
            current = intervals[i];
        }
        return count;
    }

    /**
     *
     * @param interval1
     * @param interval2
     * @return
     */
    private boolean hasOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {1,2},{2,3},{3,4},{1,3}
        };
        int i = solution.eraseOverlapIntervals(input);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }
}
