package com.potato.study.leetcode.p0950;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	950. Reveal Cards In Increasing Order
 *  
 *       In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.



Example 1:

Input: [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
Explanation:
We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.


Note:

1 <= A.length <= 1000
1 <= A[i] <= 10^6
A[i] != A[j] for all i != j

 *         
 *         题目含义：
 *          https://blog.csdn.net/zjucor/article/details/84707354
 *          https://blog.csdn.net/u011732358/article/details/84785573
 *
 *          队列几个操作的区别
 *          https://blog.csdn.net/qq_31963719/article/details/78171170
 *
 *          思路：
 *          1.排序
 *          2.index 0 2 4 6 ... 设置值
 *          3.设置一个队列 将第一次遍历的其他位置的index 入队
 *          4.while 队列非空 出队两个元素 第一个设置值，第二个重新插入队伍尾部
 *
 *
 * 
 */
public class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        int index = 0;

        Queue<Integer> indexQueue = new ArrayDeque<>();

        for (int i = 0; i < deck.length; i++) {
            if (i % 2 == 0) {
                result[i] = deck[index++];
            } else {
                indexQueue.offer(i);
            }
        }
        // 如果 deck是奇数的话 还需要先进行调整一下队列
        if (deck.length % 2 == 1 && !indexQueue.isEmpty()) {
            indexQueue.offer(indexQueue.poll());
        }

        while(!indexQueue.isEmpty()) {
            int currentIndex = indexQueue.poll();
            result[currentIndex] = deck[index++];
            // 另再出队一个操作 模拟把牌放到最后的过程
            if (!indexQueue.isEmpty()) {
                indexQueue.offer(indexQueue.poll());
            }
        }
        return result;
    }

    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] deck = {17,13,11,2,3,5,7};
        int[] result = solution.deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(result));
    }
}
