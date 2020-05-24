package com.potato.study.leetcode.p0955;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	955. Delete Columns to Make Sorted II
 *  
 *      We are given an array A of N lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef","vyz"].

Suppose we chose a set of deletion indices D such that after deletions, the final array has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).

Return the minimum possible value of D.length.



Example 1:

Input: ["ca","bb","ac"]
Output: 1
Explanation:
After deleting the first column, A = ["a", "b", "c"].
Now A is in lexicographic order (ie. A[0] <= A[1] <= A[2]).
We require at least 1 deletion since initially A was not in lexicographic order, so the answer is 1.
Example 2:

Input: ["xc","yb","za"]
Output: 0
Explanation:
A is already in lexicographic order, so we don't need to delete anything.
Note that the rows of A are not necessarily in lexicographic order:
ie. it is NOT necessarily true that (A[0][0] <= A[0][1] <= ...)
Example 3:

Input: ["zyx","wvu","tsr"]
Output: 3
Explanation:
We have to delete every column.


Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
 *         
 *         题目含义：
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/delete-columns-to-make-sorted-ii/solution/shan-lie-zao-xu-ii-by-leetcode/
 *
 * 
 */
public class Solution {

    public int minDeletionSize(String[] arr) {
        int len = arr.length;
        int arrLen = arr[0].length();
        // cuts[j] is true : we don't need to check any new A[i][j] <= A[i][j+1]
        boolean[] cuts = new boolean[len-1];

        int ans = 0;
        search:
        for (int j = 0; j < arrLen; ++j) {
            // Evaluate whether we can keep this column
            for (int i = 0; i < len-1; ++i)
                if (!cuts[i] && arr[i].charAt(j) > arr[i+1].charAt(j)) {
                    // Can't keep the column - delete and continue
                    ans++;
                    continue search;
                }

            // Update 'cuts' information
            for (int i = 0; i < len-1; ++i) {
                if (arr[i].charAt(j) < arr[i+1].charAt(j)) {
                    cuts[i] = true;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        String[] arr = new String[]{"ca","bb","ac"};
        int res = solution.minDeletionSize(arr);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}
