package com.potato.study.leetcode.p0985;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	985. Sum of Even Numbers After Queries
 *  
 *         We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.



Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation:
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.


Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
1 <= queries.length <= 10000
-10000 <= queries[i][0] <= 10000
0 <= queries[i][1] < A.length
 *         
 *         思路：
 *         第一次求和， 每次都修改都进行判断
 *
 */
public class Solution {

    public int[] sumEvenAfterQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int re = 0;
        // 第一次开始前 计算even sum
        int evenSum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }
        for (int[] query : queries) {
            int index = query[1];
            int value = query[0];
            if (arr[index] % 2 == 0) {
                // 对query进行判断 ，当前改变的index 数是偶数 加煎数 偶数 直接加减
                if (value % 2 == 0) {
                    evenSum += value;
                } else { // index 数 偶数 sum 减去之前的数 然后计算
                    evenSum -= arr[index];
                }
            } else {
                if (value % 2 == 0) {// index 数 奇数 加减数 偶数 此时sum不变
                } else {  // index 数是奇数 加减数是奇数 求值 然后sum 加上
                    evenSum = evenSum + (arr[index] + value);
                }
            }
            result[re++] = evenSum;
            // 真正修改数组
            arr[index] += value;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr = {1,2,3,4};
		int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] result = solution.sumEvenAfterQueries(arr, queries);
        System.out.println(Arrays.toString(result));
    }
}
