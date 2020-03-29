package com.potato.study.leetcode.p1310;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 1310. XOR Queries of a Subarray
 *  
 *
Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the result for the given queries.


Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation:
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8
Example 2:

Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]


Constraints:

1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 10^9
1 <= queries.length <= 3 * 10^4
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] < arr.length
 *         
 *         思路：
 *          返回一个数组 ，数组每个元素对应 queries 的每个位置
 *          值为 从query 0 异或到 query 1 停止 arr大小为 3万
 *
 *
 *          https://www.cnblogs.com/qinduanyinghua/p/12158469.html
 *
 *          res i 为 0 - i 的 xor 则 从 i xor j = res j ^ res i -1 (0 -   i -1 异或2次为0)
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] tmp = new int[arr.length];
        tmp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp[i] = arr[i] ^ tmp[i-1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                result[i] = tmp[queries[i][1]];
            } else {
                result[i] = tmp[queries[i][1]] ^ tmp[queries[i][0] - 1];
            }
        }
        return result;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1,3,4,8};
        int[][] queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        int[] step = solution.xorQueries(arr, queries);
        System.out.println(Arrays.toString(step)); // 2,7,14,8

        arr = new int[]{4,8,2,10};
        queries = new int[][]{{2,3},{1,3},{0,0},{0,3}};
        step = solution.xorQueries(arr, queries);
        System.out.println(Arrays.toString(step)); // 8,0,4,4
    }
}
