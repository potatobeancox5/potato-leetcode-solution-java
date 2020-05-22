package com.potato.study.leetcode.p0881;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author liuzhao11
 *
 * 881. Boats to Save People
 *
 *
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)



Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
Note:

1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000
 *
 *
 * 题目含义：
 *
 *
 * 思路：
 *      先排序，然后设置i和j分别从头到尾开始相加，最后i==j的时候，Num+=1，跳出循环
 *      https://leetcode-cn.com/problems/boats-to-save-people/solution/jian-dan-yi-dong-by-si-tan-sen-xuan/
 *
 */
public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length -1;

        int num = 0;
        while (left <= right) {

            if (people[left] + people[right] <= limit) {
                right--;
                left++;
                num++;
            } else if (people[left] + people[right] > limit) {
                // 装不下 重的单独走吧
                right--;
                num++;
            }

            if (left == right) {
                num++;
                break;
            }
        }
        return num;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int[] people = new int[]{1,2};
        int limit = 3;
        int result = solution.numRescueBoats(people, limit);
        System.out.println(result);
        Assert.assertEquals(1, result);

    }
}
