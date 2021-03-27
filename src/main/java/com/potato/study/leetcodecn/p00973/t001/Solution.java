package com.potato.study.leetcodecn.p00973.t001;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 *
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

 （这里，平面上两点之间的距离是欧几里德距离。）

 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

  

 示例 1：

 输入：points = [[1,3],[-2,2]], K = 1
 输出：[[-2,2]]
 解释：
 (1, 3) 和原点之间的距离为 sqrt(10)，
 (-2, 2) 和原点之间的距离为 sqrt(8)，
 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 示例 2：

 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 输出：[[3,3],[-2,4]]
 （答案 [[-2,4],[3,3]] 也会被接受。）
  

 提示：

 1 <= K <= points.length <= 10000
 -10000 < points[i][0] < 10000
 -10000 < points[i][1] < 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 优先级队列
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long path1 = (long)o1[0] * o1[0] + o1[1] * o1[1];
                long path2 = (long)o2[0] * o2[0] + o2[1] * o2[1];
                return Long.compare(path1, path2);
            }
        });
        for (int i = 0; i < points.length; i++) {
            priorityQueue.add(points[i]);
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
