package com.potato.study.leetcode.p0846;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	846. Hand of Straights
 *  
 *         Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.


Note:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/hand-of-straights/solution/shun-zi-wen-ti-shu-zu-yi-chu-fa-by-kensonix/
 *
 *           1.先将数组排序，然后加到list中
 * 2.从list头部开始取出连续的W个数
 * 3.如果上一步数组长度不够，或者取不出W个连续的数，返回false
 *
 * 
 */
public class Solution {

    public boolean isNStraightHand(int[] hand, int w) {
        if (hand.length % w != 0) {
            return false;
        }
        Arrays.sort(hand);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < hand.length; i++) {
            list.add(hand[i]);
        }
        while (!list.isEmpty()) {

            Integer curVal = list.get(0);

            for(int i = 0; i < w; i++){
                if(list.size() == 0) {
                    return false;
                }
                if(!list.remove(curVal)) {
                    return false;
                }
                curVal++;
            }
        }
        return true;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int w = 3;
        boolean res = solution.isNStraightHand(hand, w);
        System.out.println(res);
        Assert.assertEquals(true, res);

        hand = new int[]{1,2,3,4,5};
        w = 4;
        res = solution.isNStraightHand(hand, w);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
