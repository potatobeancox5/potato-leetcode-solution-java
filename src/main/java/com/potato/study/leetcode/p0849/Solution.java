package com.potato.study.leetcode.p0849;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	849. Maximize Distance to Closest Person
 *  
 *         In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Note:

1 <= seats.length <= 20000
seats contains only 0s or 1s, at least one 0, and at least one 1.
 *         
 *         思路：
 *          https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/517925/Java-same-as-lee's-solution
 * 
 */
public class Solution {

    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int last = -1;
        for (int i = 0; i < seats.length; i++) {
            // 当前位置有人座时
            if (seats[i] == 1) {
                if (-1 == last) {
                    res = i;
                } else {
                    res = Math.max(res, (i - last)/2);
                }
                last = i;
            }
        }
        return Math.max(res, seats.length - last - 1);
    }


	public static void main(String[] args) {


        Solution solution = new Solution();

        int[] seats = new int[]{1,0,0,0,1,0,1};
        int res = solution.maxDistToClosest(seats);
        System.out.println(res);
        Assert.assertEquals(2, res);

        seats = new int[]{1,0,0,0};
        res = solution.maxDistToClosest(seats);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
