package com.potato.study.leetcodecn.p00149.t001;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 149. 直线上最多的点数
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 求一条线上的点 的最大数目
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                double k = 0;
                int b = 0;

                if (dx != 0) {
                    k = (double) dy / dx;
                } else {
                    b = points[i][0];
                }
                int tmp = 2;
                for (int l = j+1; l < points.length; l++) {
                    int dxk = points[i][0] - points[l][0];
                    int dyk = points[i][1] - points[l][1];
                    if (dx != 0 && k == (double)dyk/dxk) {
                        // Double.compare(k, (double)dyk/dxk) == 0
                        tmp++;
                    } else if (dx == 0 && points[l][0] == b) {
                        tmp++;
                    }
                }
                max = Math.max(max, tmp);
            }
        }
        if (points.length == 1) {
            max = 1;
        }
        return max;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{
                {1,1}, {2,2}, {3,3}
        };
        int i = solution.maxPoints(arr);
        System.out.println(i);
        Assert.assertEquals(3, i);

        arr = new int[][]{
                {1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}
        };
        i = solution.maxPoints(arr);
        System.out.println(i);
        Assert.assertEquals(4, i);

        arr = new int[][]{
                {2,3}, {3,3}, {-5,3}
        };
        i = solution.maxPoints(arr);
        System.out.println(i);
        Assert.assertEquals(3, i);
    }

}
