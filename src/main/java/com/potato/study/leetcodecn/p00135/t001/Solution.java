package com.potato.study.leetcodecn.p00135.t001;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

 你需要按照以下要求，帮助老师给这些孩子分发糖果：

 每个孩子至少分配到 1 个糖果。
 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 那么这样下来，老师至少需要准备多少颗糖果呢？

  

 示例 1：

 输入：[1,0,2]
 输出：5
 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 示例 2：

 输入：[1,2,2]
 输出：4
 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/candy
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 不知道我的策略管不管用
     * 先初始化 成1 然后从左右遍历 如果当前位置 比之前位置评分更高，那么 这个位置糖更多
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        if (null == ratings) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = new int[] {
                1,0,2
        };
        int i = solution.candy(ratings);
        System.out.println(i);
        Assert.assertSame(5, i);

        ratings = new int[] {
                1,2,2
        };
        i = solution.candy(ratings);
        System.out.println(i);
        Assert.assertSame(4, i);
    }
}
