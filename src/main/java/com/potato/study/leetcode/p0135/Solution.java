package com.potato.study.leetcode.p0135;

/**
 * 
 * @author liuzhao11
 * 
 *      135. Candy
 *         
 *   There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
 *         
 *         思路：
 *         据说这是贪心算法
 *         从左想有遍历
 *         最开始为1 
 *         	如果i + 1 小于等于 i 那么 i+1 = 1
 *         	如果i + 1 大于i 那么 i+1 = i位置++
 *         从右向左遍历
 *         	同理进行修正
 *         	如果i - 1 小于等于 i 那么 i+1 = 1
 *         	如果i - 1 大于i 那么 i+1 = i位置++
 *        https://www.cnblogs.com/AndyJee/p/4483043.html
 *        https://www.jianshu.com/p/4fc4e970dfec
 * 
 */
public class Solution {

	public int candy(int[] ratings) {
		int[] count = new int[ratings.length];
		count[0] = 1;
        for(int i = 0 ; i < ratings.length - 1 ; i++) {
        		if(ratings[i+1] > ratings[i]) {
        			count[i+1] = count[i] + 1;
        		} else {
        			count[i+1] = 1;
        		}
        }
        // 修正之前设定的值 因为没有考虑 右边邻居的情况
        for(int i = ratings.length - 1 ; i > 0 ; i--) {
        		if(ratings[i-1] > ratings[i] && count[i - 1] <= count[i]) {
        			count[i - 1] = count[i] + 1;
        		}
        }
        int sum = 0;
        for (int i : count) {
			sum += i;
		}
        return sum;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] ratings = {1,0,2};
		int[] ratings = {1,2,2};
		int sum = solution.candy(ratings);
		System.out.println(sum);
	}
}
