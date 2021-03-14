package com.potato.study.leetcodecn.p01773.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 *
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。

 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。

 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：

 ruleKey == "type" 且 ruleValue == typei 。
 ruleKey == "color" 且 ruleValue == colori 。
 ruleKey == "name" 且 ruleValue == namei 。
 统计并返回 匹配检索规则的物品数量 。

  

 示例 1：

 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 输出：1
 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 示例 2：

 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 输出：2
 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
  

 提示：

 1 <= items.length <= 104
 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 ruleKey 等于 "type"、"color" 或 "name"
 所有字符串仅由小写字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-items-matching-a-rule
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 按照 ruleKey 和 value 计数
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            if ("type".equals(ruleKey) && ruleValue.equals(item.get(0))) {
                count++;
            } else if ("color".equals(ruleKey) && ruleValue.equals(item.get(1))) {
                count++;
            } else if ("name".equals(ruleKey) && ruleValue.equals(item.get(2))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> items = new ArrayList<>();
        items.add(Lists.newArrayList("phone","blue","pixel"));
        items.add(Lists.newArrayList("computer","silver","phone"));
        items.add(Lists.newArrayList("phone","gold","iphone"));
        String ruleKey = "type";
        String ruleValue = "phone";
        int i = solution.countMatches(items, ruleKey, ruleValue);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }
}
