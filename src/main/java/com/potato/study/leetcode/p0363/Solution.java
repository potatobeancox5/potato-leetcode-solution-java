package com.potato.study.leetcode.p0363;

import org.junit.Assert;

import java.util.TreeSet;

/**
 * 
 * @author liuzhao11
 * 
 *        363. Max Sum of Rectangle No Larger Than K
 * 
 *    Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
and 2 is the max number no larger than k (k = 2).
Note:

The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
 *         
 *         思路：
 *          https://blog.csdn.net/jmspan/article/details/51738372
 *          1. 计算一个矩阵 ，每个 valueSum[i][j] = 求和 matrix[m][j] m<=i
 *          2. 三重循环 i j m  使用 i控制当前从哪个行开始计算和 j控制行的结束 m 控制 当前计算到哪个列
 *          3. 分别计算 从 行从到j 列从0到m的和
 *              如何和等于k 直接返回
 *              如果和小于k ，比较max
 *              获取 treeset中 大于等于 sum - k 最小的值
 *              使用sum 减去这个值 并与max 比较求解
 *              将本次进行比较的sum 方到treeset中缓存（注意treeset 实在j的循环内创建 并缓存 当前从i到j 有哪些sum的）
 *        
 */
public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 1. 计算一个矩阵 ，每个 valueSum[i][j] = 求和 matrix[m][j] m<=i
        int[][] valueSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                valueSum[i][j] = matrix[i][j];
                if (i > 0) {
                    valueSum[i][j] += valueSum[i-1][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        // 2. 三重循环 i j m  使用 i控制当前从哪个行开始计算和 j控制行的结束 m 控制 当前计算到哪个列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                TreeSet<Integer> thisBlockSumSet = new TreeSet<>();
                // 计算 i-j  0-m 的和
                int thisBlockSum = 0;
                for (int m = 0; m < matrix[0].length; m++) {
                    // 计算 i-j  0-m 的和
                    thisBlockSum += valueSum[j][m];
                    if (i > 0) {
                        thisBlockSum -= valueSum[i-1][m];
                    }
                    // 如何和等于k 直接返回
                    if (thisBlockSum == k) {
                        return k;
                    }
                    // 如果和小于k ，比较max
                    if (thisBlockSum < k) {
                        max = Math.max(max, thisBlockSum);
                    }
                    // 获取 之前的计算的和 （因为列都是计算 0- m的）
                    Integer minusBlock = thisBlockSumSet.ceiling(thisBlockSum - k);
                    if (minusBlock != null) {
                        max = Math.max(max, thisBlockSum - minusBlock);
                    }
                    thisBlockSumSet.add(thisBlockSum);
                }
            }
        }
        return max;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] matrix = {{1,0,1}, {0,-2,3}};
        int k = 2;
		int res = solution.maxSumSubmatrix(matrix, k);
		System.out.println(res);
        Assert.assertEquals(2, res);
	}
}
