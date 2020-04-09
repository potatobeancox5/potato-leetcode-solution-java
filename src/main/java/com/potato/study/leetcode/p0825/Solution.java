package com.potato.study.leetcode.p0825;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	825. Friends Of Appropriate Ages
 *  
 *         Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output:
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.


Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.
 *         
 *         思路：
 *          https://www.jianshu.com/p/37aecd1d0ac6
 * 
 */
public class Solution {

    public int numFriendRequests(int[] ages) {
        // 计数年龄
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        // 遍历计数器 j = i / 2 + 8  -  i 计算总个数
        int sum = 0;
        for (int i = 1; i < count.length; i++) {
            for (int j = i / 2 + 8; j <= i ; j++) {
                if (i == j) {
                    // x 中 选一个人 x-1中选一个人
                    sum += count[i] * (count[i] - 1);
                } else {
                    // x * y
                    sum += count[i] * count[j];
                }
            }
        }
        return sum;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] ages = new int[]{16,16};
        int res = solution.numFriendRequests(ages);
        System.out.println(res);
        Assert.assertEquals(2, res);

        ages = new int[]{16,17,18};
        res = solution.numFriendRequests(ages);
        System.out.println(res);
        Assert.assertEquals(2, res);

        ages = new int[]{20,30,100,110,120  };
        res = solution.numFriendRequests(ages);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
