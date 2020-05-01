package com.potato.study.leetcode.p0914;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	914. X of a Kind in a Deck of Cards
 *  
 *      In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.


Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.
Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.
Example 4:

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].
Example 5:

Input: deck = [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2].


Constraints:

1 <= deck.length <= 10^4
0 <= deck[i] < 10^4

 *         
 *         题目含义：
 *
 *         思路：
 *         https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qia-pai-fen-zu-by-leetcode-solution/
 *
 *
 *
 *
 */
public class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        // 计数
        int[] count = new int[10000];
        // 求每个count的公约数
        for (int num : deck) {
            count[num]++;
        }
        int gcd = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (gcd == -1) {
                    gcd = count[i];
                } else {
                    gcd = gcd(gcd, count[i]);
                }
            }
        }
        return gcd >= 2;
    }

    /**
     * 求最大公约数 辗转相除
     * @param a
     * @param b
     * @return
     */
    public int gcd (int a, int b) {
        return a == 0 ? b : gcd(b%a, a);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] deck = new int[]{1,2,3,4,4,3,2,1};
        boolean b = solution.hasGroupsSizeX(deck);
        System.out.println(b);
        Assert.assertEquals(true, b);

        deck = new int[]{1,1,1,2,2,2,3,3};
        b = solution.hasGroupsSizeX(deck);
        System.out.println(b);
        Assert.assertEquals(false, b);

        deck = new int[]{1};
        b = solution.hasGroupsSizeX(deck);
        System.out.println(b);
        Assert.assertEquals(false, b);

        deck = new int[]{1,1,2,2,2,2};
        b = solution.hasGroupsSizeX(deck);
        System.out.println(b);
        Assert.assertEquals(true, b);
    }
}
