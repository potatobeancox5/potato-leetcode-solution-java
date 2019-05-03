package com.potato.study.leetcode.p0575;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         575. Distribute Candies
 * 
 *         Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
The sister has two different kinds of candies, the brother has only one kind of candies.
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].
 * 
 * 
 *         思路：
 *         计算有多少种糖果 set 然后比较 糖果数 和 总数/2
 *       
 *          
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        int sum = candies.length;
        Set<Integer> candySet = new HashSet<>();
        for (int candy : candies) {
            candySet.add(candy);
        }
        return candySet.size() > (sum / 2) ? sum / 2 : candySet.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] candies = {1,1,2,2,3,3};
        int[] candies = {1,1,2,3};
        int nums = solution.distributeCandies(candies);
        System.out.println("nums:" + nums);
    }
}
