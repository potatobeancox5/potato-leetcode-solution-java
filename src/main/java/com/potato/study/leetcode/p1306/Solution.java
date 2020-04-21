package com.potato.study.leetcode.p1306;



import org.junit.Assert;


/**
 * 
 * @author liuzhao11
 * 
 * 	1306. Jump Game III
 *  
 *
Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.



Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.


Constraints:

1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length

 *         
 *         思路：
 *
 *

 *
 */
public class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReachDfs(arr, start, visited);
    }

    private boolean canReachDfs(int[] arr, int start, boolean[] visited) {
        if (arr[start] == 0) {
            return true;
        }

        visited[start] = true;

        int minus = start - arr[start];
        if (minus >= 0 && !visited[minus] && canReachDfs(arr, minus, visited)) {
            return true;
        }
        int plus = arr[start] + start;
        if (plus < arr.length && !visited[plus] && canReachDfs(arr, plus, visited)) {
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{4,2,3,0,3,1,2};
        int start = 5;
        boolean res = solution.canReach(arr, start);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{4,2,3,0,3,1,2};
        start = 0;
        res = solution.canReach(arr, start);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{3,0,2,1,2};
        start = 2;
        res = solution.canReach(arr, start);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
