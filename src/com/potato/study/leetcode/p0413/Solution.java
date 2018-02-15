package com.potato.study.leetcode.p0413;

/**
 * 
 * @author liuzhao11
 * 
 *         413. Arithmetic Slices
 * 
 *         A sequence of number is called arithmetic if it consists of at least
 *         three elements and if the difference between any two consecutive
 *         elements is the same.
 * 
 *         For example, these are arithmetic sequence:
 * 
 *         1, 3, 5, 7, 9 7, 7, 7, 7 3, -1, -5, -9 The following sequence is not
 *         arithmetic.
 * 
 *         1, 1, 2, 5, 7
 * 
 *         A zero-indexed array A consisting of N numbers is given. A slice of
 *         that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * 
 *         A slice (P, Q) of array A is called arithmetic if the sequence: A[P],
 *         A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this
 *         means that P + 1 < Q.
 * 
 *         The function should return the number of arithmetic slices in the
 *         array A.
 * 
 * 
 *         Example:
 * 
 *         A = [1, 2, 3, 4]
 * 
 *         return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1,
 *         2, 3, 4] itself.
 * 
 * 
 *         思路： 动态规划题目
 *         1.将数组排序 
 *         2.遍历结果 每个位置开始进行两两比较 计算数列的个数 
 *         如果满足 a[i] - a[i-1] == a[i-1] - a[i-2] 数列个数++
 *         每个位置都作为起始位置++
 *         比如[1,2,3,4,5]
 *         以1为开始 等差数列为[1,2,3] [1,2,3,4] [1,2,3,4,5]
 *         再以2为开始 等差数列为[2,3,4] [2,3,4,5]
 *         再以3为开始 等差数列为[3,4,5]
 *         总共 6 组
 * 
 */
public class Solution {
	
	/**
	 * 这道题 不能进行排序 保持数组原来的特性 
	 * @param A
	 * @return
	 */
	public int numberOfArithmeticSlices(int[] A) {
		int[] arr = A;
        //Arrays.sort(arr);
        // 遍历结果 并进行比较 
        int sum = 0;
        for(int j = 0 ; j < arr.length - 2; j++) {  
        		int count = 0;
	        	for(int i = j ; i < arr.length - 2; i++) {
	        		if(arr[i+2] - arr[i+1] == arr[i+1] - arr[i]) { // 等差数列
	        			count++;
	        		} else {
	        			break;
	        		}
	        	}
	        	sum += count;
        }
        return sum;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {1,2,3,8,9,10};
		int count = solution.numberOfArithmeticSlices(A);
		System.out.println(count);
	}
}
