package com.potato.study.leetcode.p0969;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	969. Pancake Sorting

 *  
 *      Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.



Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation:
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.


Note:

1 <= A.length <= 100
A[i] is a permutation of [1, 2, ..., A.length]

 *         
 *         题目含义：
 *              先序列遍历整个树能被最少的camera覆盖
 *         思路：
 *              https://blog.csdn.net/mike_learns_to_rock/article/details/85938120
                遍历数组 每次找到第i大的 将其放到第一位 然后在移动到最后一位
 *
 *
 *
 *
 *
 *
 * 
 */
public class Solution {


    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> optionsList = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) { // 每次搞定一个位置的值
            // 找到i 位置的值 将其放到第一位置 (i+1)
            int index = 0;
            while(arr[index] != i + 1 && index <= i) {
                index++;
            }
            // 找到 交换到第一个位置 交换 0 - index
            if (index != i) {
                reverse(arr, index);
                optionsList.add(index + 1);

                // 交换0 - i
                reverse(arr, i);
                optionsList.add(i + 1);
            }
        }
        return optionsList;
    }


    /**
     * 交换0 到 pos 的数字
     * @param arr
     * @param pos
     */
    private void reverse(int[] arr, int pos) {
        if (pos <= 0) {
            return;
        }
        for (int i = 0; i <= pos / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[pos - i];
            arr[pos - i] = tmp;
        }
    }




    public static void main(String[] args) {
		Solution solution = new Solution();

		int[] arr = {3,2,4,1};
        List<Integer> list = solution.pancakeSort(arr);
        System.out.println(list);
    }
}
