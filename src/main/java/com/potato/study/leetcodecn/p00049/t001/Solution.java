package com.potato.study.leetcodecn.p00049.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/group-anagrams
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 strs 统计 次数 ，次数生成指纹 作为 key 值是 set word
     * 生成
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (null == strs) {
            return list;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = this.countAndGenerateFingerPrint(strs[i]);
            List<String> list1 = map.getOrDefault(key, new ArrayList<>());
            list1.add(strs[i]);
            map.put(key, list1);
        }
        if (map.isEmpty()) {
            return list;
        }
        for (List<String> list2 : map.values()) {
            list.add(new ArrayList<>(list2));
        }
        return list;
    }

    private String countAndGenerateFingerPrint(String word) {
        int[] count = new int[26];
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            builder.append(count[i]).append("-");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);

        strs = new String[] {
                "", ""
        };
        lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }
}
