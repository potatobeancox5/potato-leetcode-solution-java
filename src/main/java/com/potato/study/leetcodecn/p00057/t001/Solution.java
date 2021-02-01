package com.potato.study.leetcodecn.p00057.t001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

  

 示例 1：

 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 输出：[[1,5],[6,9]]
 示例 2：

 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 输出：[[1,2],[3,10],[12,16]]
 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
  

 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/insert-interval
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 intervals 判断 newInterval 与 intervals 是否有交集，
     * 如果没有的话 插入 结果
     * 如果有的话 ，合并并依次往后合并 知道没有交集
     *
     * 遍历 数组 intervals interval
     * 如果 interval 与 newInterval不交叉 插入 返回列表
     * 存在交叉 计算交叉 更新 node
     * 剪枝 如果上次没有merge 且当前不需要合并，直接合并吧 不用在记性比较了
     *
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int index = 0;
        boolean hasMerged = false;
        while (index < intervals.length) {
            int[] current = intervals[index++];
            if (hasCross(current, newInterval)) {
                newInterval = merge(newInterval, current);
            } else if (isBefore(newInterval, current)) {
                res.add(newInterval);
                newInterval = current;
            } else {
                res.add(current);
            }
        }
        // 处理 一直剩下的 那个
        if (null != newInterval) {
            res.add(newInterval);
        }
        // 处理成数组
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    /**
     * 合并两个 区间
     * @param newInterval
     * @param current
     * @return
     */
    private int[] merge(int[] newInterval, int[] current) {
        return new int[] {Math.min(newInterval[0], current[0]), Math.max(newInterval[1], current[1])};
    }

    /**
     * 是否有交叉 true 是有 交叉
     * @param interval1
     * @param interval1
     * @return
     */
    private boolean hasCross(int[] interval1, int[] interval2) {

        if (null == interval1 || null == interval2) {
            return false;
        }

        if (interval1[0] <= interval2[0] && interval2[0] <= interval1[1]) {
            return true;
        }
        if (interval2[0] <= interval1[0] && interval1[0] <= interval2[1]) {
            return true;
        }
        return false;
    }

    /**
     * interval1 是否在 interval2 之前
     * @param interval1
     * @param interval2
     * @return
     */
    private boolean isBefore(int[] interval1, int[] interval2) {
        if (interval1 == null || interval2 == null) {
            return false;
        }
        return interval1[1] < interval2[0];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][] {{1,3},{6,9}};
        int[] newInterval = new int[] {2,5};
        int[][] res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res)); // [[1,5],[6,9]]

        intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        newInterval = new int[] {4,8};
        res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res)); // [[1,2],[3,10],[12,16]]

        intervals = new int[][] {{1,2}};
        newInterval = new int[] {0, 0};
        res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res)); // [[0, 0], [1, 2]]
    }
}
