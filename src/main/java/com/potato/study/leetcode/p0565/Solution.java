package com.potato.study.leetcode.p0565;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @author liuzhao11
 * 
 *        565. Array Nesting
 * 
 *         A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.



Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}


Note:

N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].
 * 
 * 
 *         思路：
 *         565. Array Nesting



https://blog.csdn.net/xdhc304/article/details/79113343

set记录访问的结点
遍历数组
cnt =0
k = i
while set 不包含 num k
cnt++
set add
k = num k
比较max


https://blog.csdn.net/xdhc304/article/details/79113343
 *
 *
 *          
 */
public class Solution {

    private Set<Integer> visitedSet = new HashSet<>();

    public int arrayNesting(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int curLen = 0;
            int index = i;
            while (!visitedSet.contains(nums[index])) {
                visitedSet.add(nums[index]);
                index = nums[index];
                curLen++;
            }
            max = Math.max(max, curLen);
        }

        return max;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {5,4,0,3,1,6,2};
        int res = solution.arrayNesting(nums);
        System.out.println(res);
        Assert.assertEquals(4, res);
    }
}
