package com.potato.study.leetcode.p0587;

import com.potato.study.leetcode.util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         587. Erect the Fence
 * 
 *         There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.



Example 1:

Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:

Example 2:

Input: [[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
Explanation:

Even you only have trees in a line, you need to use rope to enclose them.


Note:

All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
All input integers will range from 0 to 100.
The garden has at least one tree.
All coordinates are distinct.
Input points have NO order. No order required for output.
input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *       
 *
 *
 *          587. Erect the Fence



https://blog.csdn.net/LaputaFallen/article/details/79808538

凸包问题的几种算法
 */
public class Solution {

    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
    private int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
    public int[][] outerTrees(int[][] points) {
        int n = points.length;
        if (n < 4) {
            return points;
        }
        Set<int[]> hull = new HashSet();
        int leftMost = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] < points[leftMost][0]) {
                leftMost = i;
            }
        }
        int p = leftMost;
        List<int[]> list = new ArrayList();
        do {
            int q = (p + 1) % n;
            for (int i = 0; i < points.length; i++) {
                int orientationRes = orientation(points[p], points[q], points[i]);
                if (orientationRes < 0) {
                    q = i;
                    list = new ArrayList();
                } else if(orientationRes == 0) {
                    if(distance(points[p], points[q]) >= distance(points[p], points[i])) {
                        list.add(points[i]);
                    } else {
                        list.add(points[q]);
                        q = i;
                    }
                }
            }
            list.add(points[q]);
            hull.addAll(list);
            p = q;
        } while (p != leftMost);

        int[][] res = new int[hull.size()][2];
        int i = 0;
        for(int[] h: hull) {
            res[i++] = h;
        }
        return res;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] points = {};

        int[][] sum = solution.outerTrees(points);
        ArrayUtil.printMatrix(sum);
    }
}
