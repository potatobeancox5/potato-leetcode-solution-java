package com.potato.study.leetcodecn.p00575.t001;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 575. 分糖果
 *
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

 示例 1:

 输入: candies = [1,1,2,2,3,3]
 输出: 3
 解析: 一共有三种种类的糖果，每一种都有两个。
 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 示例 2 :

 输入: candies = [1,1,2,3]
 输出: 2
 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 注意:

 数组的长度为[2, 10,000]，并且确定为偶数。
 数组中数字的大小在范围[-100,000, 100,000]内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/distribute-candies
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 数组 统计map 数字出现次数
     * 对于出现2次的糖果 直接计数，并从map 中刨除
     * 此时map 中有2中糖果 1 出现1次，2已经被拿过的糖果，
     * 4这种 2颗 求均值 即可 如果 2种 4颗 求min
     * 之后每次从 只出现一次的糖果拿出来给妹妹，再在已经被拿过的糖果中那一个给弟弟
     * 如果 已经拿过的消耗完
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int candy : candyType) {
            Integer count = countMap.getOrDefault(candy, 0);
            count++;
            countMap.put(candy, count);
        }
        int kinds = 0;
        int singleNum = 0;
        int multiNum = 0;
        for (int count : countMap.values()) {
            if (count == 2) {
                kinds++;
            } else if (count == 1) {
                singleNum++;
            } else if (count > 2) {
                kinds++;
                multiNum += (count - 2);
            }
        }
        if (singleNum > multiNum) {
            kinds += ((singleNum + multiNum)/2);
        } else {
            kinds += Math.min(singleNum, multiNum);
        }
        return kinds;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candyType = new int[] {
                1,1,2,2,3,3
        };
        int num = solution.distributeCandies(candyType);
        System.out.println(num);
        Assert.assertEquals(3, num);
    }

}
