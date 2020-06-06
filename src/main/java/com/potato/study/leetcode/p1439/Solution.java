package com.potato.study.leetcode.p1439;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1439. Find the Kth Smallest Sum of a Matrix With Sorted Rows
 *  
 *
You are given an m * n matrix, mat, and an integer k, which has its rows sorted in non-decreasing order.

You are allowed to choose exactly 1 element from each row to form an array. Return the Kth smallest array sum among all possible arrays.



Example 1:

Input: mat = [[1,3,11],[2,4,6]], k = 5
Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
Example 2:

Input: mat = [[1,3,11],[2,4,6]], k = 9
Output: 17
Example 3:

Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
Output: 9
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.
Example 4:

Input: mat = [[1,1,10],[2,2,9]], k = 7
Output: 12


Constraints:

m == mat.length
n == mat.length[i]
1 <= m, n <= 40
1 <= k <= min(200, n ^ m)
1 <= mat[i][j] <= 5000
mat[i] is a non decreasing array.
 *         
 *
 *
 *
 * 思路：
 *
 *      https://leetcode-cn.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/solution/java-bfs-zui-xiao-dui-by-bran_wang/
 *
 */
public class Solution {


    public int kthSmallest(int[][] mat, int k) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][0];
        }

        PriorityQueue<Item> pq = new PriorityQueue<>( (o1, o2) -> o1.total - o2.total );

        Set<String> visit = new HashSet<>();
        Item first = new Item(new int[mat.length], sum);
        visit.add(Arrays.toString(first.pick));
        pq.offer(first);

        while (k > 1) {
            Item item = pq.poll();

            for (int i = 0; i < mat.length; i++) {
                item.pick[i]++;

                if (item.pick[i] < mat[i].length && !visit.contains(Arrays.toString(item.pick))) {
                    visit.add(Arrays.toString(item.pick));
                    int[] pick = Arrays.copyOf(item.pick, item.pick.length);

                    int total = item.total - mat[i][item.pick[i] - 1] + mat[i][item.pick[i]];
                    pq.add(new Item(pick, total));
                }

                item.pick[i]--;
            }
            k--;
        }

        return pq.peek().total;
    }

    private class Item {
        private int[] pick;
        private int total;

        public Item(int[] pick, int total) {
            this.pick = pick;
            this.total = total;
        }
    }
}
