package com.potato.study.leetcode.p0822;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	822. Card Flipping Game
 *  
 *         On a table are N cards, with a positive integer printed on the front and back of each card (possibly different).

We flip any number of cards, and after we choose one card.

If the number X on the back of the chosen card is not on the front of any card, then this number X is good.

What is the smallest number that is good?  If no number is good, output 0.

Here, fronts[i] and backs[i] represent the number on the front and back of card i.

A flip swaps the front and back numbers, so the value on the front is now on the back and vice versa.

Example:

Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
Output: 2
Explanation: If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
We choose the second card, which has number 2 on the back, and it isn't on the front of any card, so 2 is good.


Note:

1 <= fronts.length == backs.length <= 1000.
1 <= fronts[i] <= 2000.
1 <= backs[i] <= 2000.
 *         
 *         思路：
 *
 *         https://leetcode.com/problems/card-flipping-game/discuss/527166/Java-clear-code-beats-100
 */
public class Solution {

    public int flipgame(int[] fronts, int[] backs) {
        boolean[] seen = new boolean[2001];
        boolean[] same = new boolean[2001];
        for (int i = 0; i < fronts.length; i++) {
            seen[fronts[i]] = true;
            seen[backs[i]] = true;
            if (fronts[i] == backs[i]) {
                same[backs[i]] = true;
            }
        }
        // k 出现过 且 same k false 直接返回
        for (int i = 1; i < 2001; i++) {
            if (seen[i] && !same[i]) {
                return i;
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] fronts = new int[]{1,2,4,4,7};
        int[] backs = new int[]{1,3,4,1,3};

        int res = solution.flipgame(fronts, backs);
        System.out.println(res);
        Assert.assertEquals(2, res);
    }
}
