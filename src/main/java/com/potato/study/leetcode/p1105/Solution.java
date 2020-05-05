package com.potato.study.leetcode.p1105;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1105. Filling Bookcase Shelves
 *  
 *         We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].

We want to place these books in order onto bookcase shelves that have total width shelf_width.

We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width), then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down.  We repeat this process until there are no more books to place.

Note again that at each step of the above process, the order of the books we place is the same order as the given sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.

Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.



Example 1:


Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
Output: 6
Explanation:
The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
Notice that book number 2 does not have to be on the first shelf.


Constraints:

1 <= books.length <= 1000
1 <= books[i][0] <= shelf_width <= 1000
1 <= books[i][1] <= 1000
 *
 *
 *
 *   解题思路：
 *
 *        给定每本书的厚度和高度 求 整个书架的高度（ 书架放满所有书）
 *
 *
 *        动态规划常用思路，假设第i本书为最后一本，则dp[i]表示以第i本书为最后一本的当前书架的最低高度。
第i本书有两种方法，加入当前层数能够放下第i本书，则第i本书可以
 *
 * https://leetcode-cn.com/problems/filling-bookcase-shelves/solution/chang-gui-dong-tai-gui-hua-jie-fa-by-liu-li-cui-ca/
 *
 */
public class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // 只有一本书的情况
        int num = books.length;
        if (num == 1) {
            return books[0][1];
        }
        int[] dp = new int[num];
        dp[0] = books[0][1];


        // 从第二本开始计算
        for (int i = 1; i < num; i++) {
            // height表示第i本书到i-1，i-2……本书的最大高度，一层书架的高度取决于最高的那本书
            int height = books[i][1];
            // weight则记录i-1，i-2……本书的总宽度，以此来判断能不能放下第i-n本书
            int weight = books[i][0];
            // 初始假设第i本书单独放到下一层
            dp[i] = dp[i - 1] + books[i][1];
            for (int j = i - 1; j >= 0; j--) {
                height = Math.max(height, books[j][1]);
                weight = weight + books[j][0];
                // 当前书太宽（厚），放不下，跳出循环
                if (weight > shelfWidth) {
                    break;
                }
                // 第i本到第0本书，所有的书都放到一层
                if (j == 0) {
                    dp[i] = Math.min(dp[i], height);
                } else {
                    // dp[j - 1] + height解释：
                    // height表示第i本书到第j本书最大的高度，dp[j - 1]表示以第j-1本书为最后一本书，当前书架最小的高度
                    dp[i] = Math.min(dp[i], dp[j - 1] + height);
                }

            }
        }
        return dp[num-1];
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] books = new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;
        int res = solution.minHeightShelves(books, shelfWidth);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
