package com.potato.study.leetcodecn.p00452.t001;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤
 * xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 将数据按照开始位置 升序排序
     * 每次遍历当前排序后列表 找到最左边的结束位置，那么一定有一只箭从这射出去
     * 找到所有开始点 小于等于这个结束位置的点，他们都被淘汰了
     * 依次记录个数
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        // 将数据按照开始位置 升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        // 每次遍历当前排序后列表 找到最左边的结束位置，那么一定有一只箭从这射出去
        int arrowCount = 0;
        int index = 0;
        while (index < points.length) {
            arrowCount++;

            int minRightIndex = index;
            for (int i = index; i < points.length; i++) {
                if (points[i][1] < points[minRightIndex][1]) {
                    minRightIndex = i;
                }
            }
            // 开始位置在这之前的都被淘汰了
            while (index < points.length
//                    && index != minRightIndex
                    && points[index][0] <= points[minRightIndex][1]) {
                index++;
            }
        }
        return arrowCount;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] points = new int[][] {
                {10,16},{2,8},{1,6},{7,12}
        };
        int arrowCount = solution.findMinArrowShots(points);
        System.out.println(arrowCount);
        Assert.assertEquals(2, arrowCount);

        points = new int[][] {
                {1,2},{3,4},{5,6},{7,8}
        };
        arrowCount = solution.findMinArrowShots(points);
        System.out.println(arrowCount);
        Assert.assertEquals(4, arrowCount);

        points = new int[][] {
                {1,2},{3,4},{5,6},{7,8}
        };
        arrowCount = solution.findMinArrowShots(points);
        System.out.println(arrowCount);
        Assert.assertEquals(4, arrowCount);
    }
}
