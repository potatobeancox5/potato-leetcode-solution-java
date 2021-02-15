package com.potato.study.leetcodecn.p00599.t001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. 两个列表的最小索引总和
 *
 * 设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

 示例 1:

 输入:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 输出: ["Shogun"]
 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 示例 2:

 输入:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 输出: ["Shogun"]
 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 提示:

 两个列表的长度范围都在 [1, 1000]内。
 两个列表中的字符串的长度将在[1，30]的范围内。
 下标从0开始，到列表的长度减1。
 两个列表都没有重复的元素。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> word2IndexMap = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            word2IndexMap.put(list2[i], i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            Integer index = word2IndexMap.get(list1[i]);
            if (index == null) {
                continue;
            }
            int temp = index + i;
            if (temp < minIndex) {
                minIndex = temp;
                list = new ArrayList<>();
                list.add(list1[i]);
            } else if (temp == minIndex) {
                list.add(list1[i]);
            }
        }
        // build answer
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] list1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};;
        String[] restaurant = solution.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }

}
