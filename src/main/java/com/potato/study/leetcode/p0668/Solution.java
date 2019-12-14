package com.potato.study.leetcode.p0668;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         668. Kth Smallest Number in Multiplication Table
 * 
 *         Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?

Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.

Example 1:
Input: m = 3, n = 3, k = 5
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
Example 2:
Input: m = 2, n = 3, k = 6
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
Note:
The m and n will be in the range [1, 30000].
The k will be in the range [1, m * n]
 *
 *
 *
 *         思路：
 *         第i行小雨等于 x的个数 为min (n , x / i),累加可以得到当前 x是第几位置，然后使用二分法查找即可
 *         https://www.cnblogs.com/ruruozhenhao/p/9930494.html
 *
 *
 *
 */
public class Solution {

    public int findKthNumber(int m, int n, int k) {
        long left = 1;
        long right = m * n;
        while (left < right) {
            long mid = (left + right) / 2;
            if (isBiggerThanK(m, n, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;

    }

    /**
     * 判断 target 在第k数后面么
     * @param m 行数
     * @param n 列数
     * @param k 待查的位置
     * @param target    目标数
     * @return
     */
    private boolean isBiggerThanK(int m, int n, int k, long target) {
        long count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, target / i);
        }

        return count >= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int m = 3;
        int n = 3;
        int k = 5;
        int result = solution.findKthNumber(m, n, k);
        System.out.println(result);
        Assert.assertEquals(3, result);


        m = 2;
        n = 3;
        k = 6;
        result = solution.findKthNumber(m, n, k);
        System.out.println(result);
        Assert.assertEquals(6, result);
    }
}
