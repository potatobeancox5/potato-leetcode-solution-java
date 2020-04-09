package com.potato.study.leetcode.p0823;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	823. Binary Trees With Factors
 *  
 *         Given an array of unique integers, each integer is strictly greater than 1.

We make a binary tree using these integers and each number may be used for any number of times.

Each non-leaf node's value should be equal to the product of the values of it's children.

How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

Example 1:

Input: A = [2, 4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: A = [2, 4, 5, 10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].


Note:

1 <= A.length <= 1000.
2 <= A[i] <= 10 ^ 9.
 *         
 *         思路：
 *            https://www.cnblogs.com/shawshawwan/p/9558306.html
 *
 *            map value 是 表示跟为 value的 树的种类数
 *
 */
public class Solution {

    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1_000_000_007;
        // 1 升序排序 arr
        Arrays.sort(arr);
        Map<Integer, Long> rootTreeCountMap = new HashMap<>();
        // 2 for e arr 放入map key 元素 val1
        for (int i = 0; i < arr.length; i++) {
            rootTreeCountMap.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                // 3  from 0 - i  如果 arr i % arr j 等于 0 且  map.containsKey 说明 可能组成树
                if (arr[i] % arr[j] == 0 && rootTreeCountMap.containsKey(arr[i]/arr[j])) {
                    // 4 map key 是 arr i value (map.get(A[i]) + map.get(A[j]) * map.get(A[i] / A[j])) % kmod
                    rootTreeCountMap.put(arr[i], (rootTreeCountMap.get(arr[i])
                            + rootTreeCountMap.get(arr[j]) * rootTreeCountMap.get(arr[i] / arr[j]) % mod));
                }
            }
        }
        // 5 sum map value 返回
        long res = 0;
        for (long count : rootTreeCountMap.values()) {
            res += count;
        }
        return (int) (res % mod);
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{2, 4};
        int res = solution.numFactoredBinaryTrees(arr);
        System.out.println(res);
        Assert.assertEquals(3, res);

        arr = new int[]{2, 4, 5, 10};
        res = solution.numFactoredBinaryTrees(arr);
        System.out.println(res);
        Assert.assertEquals(7, res);
    }
}
