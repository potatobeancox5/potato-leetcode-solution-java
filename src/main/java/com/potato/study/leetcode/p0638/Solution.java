package com.potato.study.leetcode.p0638;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author liuzhao11
 * 
 *         638. Shopping Offers
 * 
 *         In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation:
There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B.
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation:
The price of A is $2, and $3 for B, $4 for C.
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
You cannot add more items, though only $9 for 2A ,2B and 1C.
Note:
There are at most 6 kinds of items, 100 special offers.
For each item, you need to buy at most 6 of them.
You are not allowed to buy more items than you want, even if that would lower the overall price.
 * 
 *         思路：
 *
 *         638. Shopping Offers

题目含义：

要买一定数量的东西，有些组合打特价

问最少需要花多少钱

https://blog.csdn.net/gqk289/article/details/76086375

1. 计算出 没有使用优惠set时 需要花多少钱

2.对于当前need 需要

遍历组合

https://www.jianshu.com/p/b4f6b2962ede


遍历每个 特殊的set
// 改变每个 need 位置 并判断 是否是可用的set

// 如果每个位置都是可用时，递归找 最小的need
并将 递归找到的need 与 当前的result 进行对比


// 还原 之前改变的need


// 将上述获得的result 与 1 的结果对比

 注意： 不能浪费
 */
public class Solution {


    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        // 1. 使用优惠需要多少钱
        int lowestCostUseSet = Integer.MAX_VALUE;
        // 遍历每个 特殊的set
        for (int i = 0; i < special.size(); i++) {
            // 改变每个 need 位置 并判断 是否是可用的set
            List<Integer> specialSet = special.get(i);
            // 只有 当前数量满足 needs的时候 才是valid
            boolean isValidSet = true;
            for (int j = 0; j < needs.size(); j++) {
                int remianCount = needs.get(j) - specialSet.get(j);
                needs.set(j, remianCount);
                if (isValidSet && remianCount < 0) {
                    isValidSet = false;
                }
            }
            // 如果这个 specialSet 没问题 递归
            if (isValidSet) {
                int specialSetPrice = specialSet.get(specialSet.size() - 1);
                lowestCostUseSet = Math.min(lowestCostUseSet, specialSetPrice + shoppingOffers(price, special, needs));
            }
            // 还原needs
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + specialSet.get(j));
            }

        }
        // 2. 计算出 没有使用优惠set时 需要花多少钱
        int costBuySimple = 0;
        for (int i = 0; i < needs.size(); i++) {
            int needSimpleCount = needs.get(i);
            costBuySimple += (needSimpleCount * price.get(i));
        }

        return Math.min(costBuySimple, lowestCostUseSet);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        // 单品价格
        int[] priceArr = {2,5};
        List<Integer> price = Arrays.stream(priceArr).boxed().collect(Collectors.toList());

        // 套装价格
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.stream(new int[]{3,0,5}).boxed().collect(Collectors.toList()));
        special.add(Arrays.stream(new int[]{1,2,10}).boxed().collect(Collectors.toList()));

        // 要买多少个物品
        int[] needsArr = {3,2};
        List<Integer> needs = Arrays.stream(needsArr).boxed().collect(Collectors.toList());

        int lowestPrice = solution.shoppingOffers(price, special, needs);
        System.out.println(lowestPrice);
        Assert.assertEquals(14, lowestPrice);
    }
}
