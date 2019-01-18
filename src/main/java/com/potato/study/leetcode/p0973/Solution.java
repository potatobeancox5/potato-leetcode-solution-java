package com.potato.study.leetcode.p0973;

import com.potato.study.leetcode.util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	973. K Closest Points to Origin
 *  
 *       We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)


Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
 *         
 *         思路：
 *          大根堆
 *          最后一次出堆 直到最后的k个数字
 *
 * 
 */
public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  -1 * (o1[0] * o1[0] +  o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
            }
        });
        for (int[] point : points) {
            heap.add(point);
        }
        // pop len - K 个数字
        for (int i = 0; i < points.length - K; i++) {
            heap.remove();
        }
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[i] = heap.remove();
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[][] points = {{1,3},{-2,2}};
//		int k = 1;
		// [[3,3],[5,-1],[-2,4]], K = 2
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] closest = solution.kClosest(points, k);
        ArrayUtil.printMatrix(closest);
    }
}
