package com.potato.study.leetcode.p1329;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1329. Sort the Matrix Diagonally
 *  
 *
Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.



Example 1:


Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100
 *         
 *         思路：
 *
 *          按照对角线升序进行排序
 *
 *          map 优先队列 key i- j value 优先队列 对角线的值 对角线特性就是下表相加 相同
 *          https://www.cnblogs.com/wentiliangkaihua/p/12239553.html
 *
 *
 *

 *
 */
public class Solution {

    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                PriorityQueue<Integer> heap = map.getOrDefault(i - j, new PriorityQueue<>());
                heap.add(mat[i][j]);
                map.put(i -j, heap);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                PriorityQueue<Integer> heap = map.get(i - j);
                Integer value = heap.poll();
                mat[i][j] = value;
            }
        }
        return mat;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] matrix = solution.diagonalSort(mat);
        System.out.println(Arrays.deepToString(matrix));
    }
}
