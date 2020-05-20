package com.potato.study.leetcode.p0875;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 *
 *
 * 875. Koko Eating Bananas
 *
 *
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.



Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23


Note:

1 <= piles.length <= 10^4
piles.length <= H <= 10^9
1 <= piles[i] <= 10^9

 *
 *
 *
 * 题目含义：
 *
 *
 * 思路：
 * https://leetcode-cn.com/problems/koko-eating-bananas/solution/suo-yi-ke-ke-shi-ge-hou-zi-ma-by-jin-ai-yi/
 *
 *      二分法查找
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = piles[0];
        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        }
        // 待查找区间起始点，无穷的时间里，以最慢的速度吃香蕉，不过因为K为整数，所以取1
        int left = 1;
        int right = maxPile;//待查找区间终点，最少的时间H=piles.length，所以一小时吃完一堆

        int mid = -1;
        int res = -1;
        while (left <= right){
            //开始二分
            mid = (left + right) / 2;
            // 是否可以在 h天内 以 mid的速度吃完
            if(canEatOut(piles, h, mid)) {
                right = mid - 1;
                res = mid;
            } else {
                //要找的是“能吃完”的所有速度的最小值，即它们的左边界
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean canEatOut(int[] piles, int h, int speed) {
        int costDays = 0;
        for (int pile : piles) {
            costDays += (pile == speed ? 1 : pile / speed + 1);
            if (costDays > h) {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        int sim = solution.minEatingSpeed(piles, h);
        System.out.println(sim);
        Assert.assertEquals(4, sim);


        piles = new int[]{30,11,23,4,20};
        h = 5;
        sim = solution.minEatingSpeed(piles, h);
        System.out.println(sim);
        Assert.assertEquals(30, sim);

        piles = new int[]{30,11,23,4,20};
        h = 6;
        sim = solution.minEatingSpeed(piles, h);
        System.out.println(sim);
        Assert.assertEquals(23, sim);
    }

}
