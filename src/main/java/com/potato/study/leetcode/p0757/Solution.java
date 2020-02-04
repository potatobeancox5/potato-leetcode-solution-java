package com.potato.study.leetcode.p0757;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 * 	757. Set Intersection Size At Least Two
 *  
 *         An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.

Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.

Example 1:
Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
Output: 3
Explanation:
Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
Also, there isn't a smaller size set that fulfills the above condition.
Thus, we output the size of this set, which is 3.
Example 2:
Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
Output: 5
Explanation:
An example of a minimum sized set is {1, 2, 3, 4, 5}.
Note:

intervals will have length in range [1, 3000].
intervals[i] will have length 2, representing some integer interval.
intervals[i][j] will be an integer in [0, 10^8].


 *   解题思路：
 *      找到 至少有2个交点的 set s 和 给定的那些 intervals
 *
 *      维护一个区间 s 存交集
 *
 *      https://www.cnblogs.com/grandyang/p/8503476.html
 *
 *      https://blog.csdn.net/excellentlizhensbfhw/article/details/84261646
 */
public class Solution {


    public int intersectionSizeTwo(int[][] intervals) {

        // 0 按照start 升序 end 降序进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[] needCount = new int[intervals.length];
        Arrays.fill(needCount, 2);
        // 1 从后向前进行遍历
        //      每次 从star他开始试验 测试count t 个数字，每次修改 count
        int size = 0;
        for (int i = intervals.length - 1; i >= 0; i--) {

            int start = intervals[i][0];
            // 从中选择 可以使用的数字
            for (int j = start; j < start + needCount[i]; j++) {
                // 去其他集合将这个数字删去
                for (int k = 0; k < i; k++) {
                    // j 比 end 小 一定比 start大
                    if (j <= intervals[k][1]) {
                        needCount[k]--;
                    }
                }
                size++;
            }

        }
        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        int count = solution.intersectionSizeTwo(intervals);
        System.out.println("count:" + count);
        Assert.assertEquals(3, count);

        int[][] intervals1 = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        count = solution.intersectionSizeTwo(intervals1);
        System.out.println("count:" + count);
        Assert.assertEquals(5, count);
    }
}
