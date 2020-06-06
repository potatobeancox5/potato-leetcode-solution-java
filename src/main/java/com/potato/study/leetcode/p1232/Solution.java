package com.potato.study.leetcode.p1232;


/**
 * 
 * @author liuzhao11
 * 
 * 	1232. Check If It Is a Straight Line
 *  
 *      You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.





Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false


Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 *         
 *
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/yi-di-yi-ge-dian-wei-can-kao-dian-qi-ta-dian-yi-ca/
 *
 */
public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[1][0]-coordinates[0][0];
        int y1 = coordinates[1][1]-coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0]-coordinates[0][0];
            int y2 = coordinates[i][1]-coordinates[0][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }

}
