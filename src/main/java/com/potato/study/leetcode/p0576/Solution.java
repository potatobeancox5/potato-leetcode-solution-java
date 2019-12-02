package com.potato.study.leetcode.p0576;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         576. Out of Boundary Paths
 * 
 *        There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.



Example 1:

Input: m = 2, n = 2, N = 2, i = 0, j = 0
Output: 6
Explanation:

Example 2:

Input: m = 1, n = 3, N = 3, i = 0, j = 1
Output: 12
Explanation:



Note:

Once you move the ball out of boundary, you cannot move it back.
The length and height of the grid is in range [1,50].
N is in range [0,50].
 * 
 * 
 *         思路：
 *         576. Out of Boundary Paths

https://blog.csdn.net/excellentlizhensbfhw/article/details/81879651

if ij 达到边界 返回1

if N 剩余0步 返回 0


先从map取key值

key i，j，N


sum =0

sum += 上下 左右 每次都对给定数取余数

sum对给定数取余数

放入map
返回sum
 *
 *       使用map记录 当前 i j 位置 在 times 步数下 有多少种走出的办法
 *          
 */
public class Solution {

    // 使用map记录 当前 i j 位置 在 times 步数下 有多少种走出的办法
    private Map<String, Integer> pathNumMap = new HashMap<>();

    private int mod = 1000000007;

    public int findPaths(int m, int n, int times, int i, int j) {
        //if ij 达到边界 返回1
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (times == 0) {
            return 0;
        }
        // condtrust key
        String key = i + "#" + j + "#" + times;
        if (pathNumMap.containsKey(key)) {
            return pathNumMap.get(key);
        }
        int pathSum = 0;
        // sum += 上下 左右 每次都对给定数取余数
        pathSum += findPaths(m, n, times - 1, i-1, j);
        pathSum %= mod;

        pathSum += findPaths(m, n, times - 1, i+1, j);
        pathSum %= mod;

        pathSum += findPaths(m, n, times - 1, i, j-1);
        pathSum %= mod;

        pathSum += findPaths(m, n, times - 1, i, j+1);
        pathSum %= mod;

        pathNumMap.put(key, pathSum);

        return pathSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int m = 2;
        int n = 2;
        int times = 2;
        int i = 0;
        int j = 0;

        int paths = solution.findPaths(m, n, times, i, j);
        System.out.println(paths);
        Assert.assertEquals(6, paths);
    }
}
