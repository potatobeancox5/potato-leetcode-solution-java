package com.potato.study.leetcode.p1011;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1011. Capacity To Ship Packages Within D Days
 *  
 *         A conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation:
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], D = 3
Output: 6
Explanation:
A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], D = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1


Note:

1 <= D <= weights.length <= 50000
1 <= weights[i] <= 500
 *         
 *         思路：
 *     1011. Capacity To Ship Packages Within D Days
求船最小载重量多少 保证d天内 能运完包裹
https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/zai-dtian-nei-song-da-bao-guo-de-neng-li-by-lenn12

 *
 */
public class Solution {

    public int shipWithinDays(int[] weights, int d) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, d, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     *
     * @param weights
     * @param d
     * @param k     当前船的承载量
     * @return
     */
    public boolean canShip(int[] weights, int d, int k) {
        int cur = k;
        for (int weight: weights) {
            if (weight > k) {
                return false;
            }
            // 装不下了
            if (cur < weight) {
                cur = k;
                d--;
            }
            cur -= weight;
        }
        return d > 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int d = 5;
        int b = solution.shipWithinDays(weights, d);
        System.out.println(b);
        Assert.assertEquals(15, b);


        weights = new int[]{3,2,2,4,1,4};
        d = 3;
        b = solution.shipWithinDays(weights, d);
        System.out.println(b);
        Assert.assertEquals(6, b);
    }
}
