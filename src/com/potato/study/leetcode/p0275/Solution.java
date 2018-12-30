package com.potato.study.leetcode.p0275;

/**
 * 
 * @author liuzhao11
 * 
 *
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
received 0, 1, 3, 5, 6 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining
two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?


        题目含义：
            计算几个学者的h-index
            h - index 学者有h 篇论文 在h次引用以上
* 		思路：
 * 	        1. 排序 降序 题目已经保证
 * 	        2. 找到第一个index >= num【index】的index
 * 	        https://blog.csdn.net/u014328357/article/details/52169682
 *
 *
* 
 */
public class Solution {

    public int hIndex(int[] citations) {
        if (null == citations || citations.length == 0) {
            return 0;
        }
//        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0 ; i--) {
            int index = citations.length - i - 1;
            if (index >= citations[i]) {
                return index;
            }
        }
        return citations.length;
    }
	
	
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] citations = {3,0,6,1,5};
//        int[] citations = {1};
        int[] citations = {0 ,1,3,5,6};
        // 6 5 3 1 0
        // 0 1 3 5 6
        // 0 1 2 3 4
        int hIndex = solution.hIndex(citations);
        System.out.println("hIndex: " + hIndex);
    }
}