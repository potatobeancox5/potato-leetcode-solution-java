package com.potato.study.leetcodecn.p00378.t001;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;

/**
 * 378. 有序矩阵中第 K 小的元素
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *  
 *
 * 提示：
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        priorityQueue.add(new int[] {matrix[0][0], 0, 0});
        boolean[][] hasVisited = new boolean[matrix.length][matrix[0].length];
        hasVisited[0][0] = true;
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            count++;
            if (count == k) {
                return poll[0];
            }
            // 添加其他
            if (poll[1] < matrix.length - 1 && !hasVisited[poll[1]+1][poll[2]]) {
                hasVisited[poll[1]+1][poll[2]] = true;
                priorityQueue.add(new int[] {matrix[poll[1]+1][poll[2]], poll[1]+1, poll[2]});
            }
            if (poll[2] < matrix[0].length - 1&& !hasVisited[poll[1]][poll[2]+1]) {
                hasVisited[poll[1]][poll[2]+1] = true;
                priorityQueue.add(new int[] {matrix[poll[1]][poll[2]+1], poll[1], poll[2]+1});
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                {1,5,9},{10,11,13},{12,13,15}
        };
        int k = 8;
        int i = solution.kthSmallest(matrix, k);
        System.out.println(i);
        Assert.assertEquals(13, i);


        matrix = new int[][] {
                {-5}
        };
        k = 1;
        i = solution.kthSmallest(matrix, k);
        System.out.println(i);
        Assert.assertEquals(-5, i);
    }
}
