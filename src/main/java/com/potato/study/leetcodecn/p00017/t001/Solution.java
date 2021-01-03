package com.potato.study.leetcodecn.p00017.t001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 首先初始化一个map key 0-9 value list 对应的字母，
     * 遍历 digits 每次一个数字 生成中间结果 放在list 中 ，然后两个lsit 来回倒腾
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> resultList = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return resultList;
        }

        Map<Integer, List<Character>> num2ChMap = new HashMap<>();
        num2ChMap.put(2, Arrays.asList('a', 'b', 'c'));
        num2ChMap.put(3, Arrays.asList('d', 'e', 'f'));
        num2ChMap.put(4, Arrays.asList('g', 'h', 'i'));
        num2ChMap.put(5, Arrays.asList('j', 'k', 'l'));
        num2ChMap.put(6, Arrays.asList('m', 'n', 'o'));
        num2ChMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        num2ChMap.put(8, Arrays.asList('t', 'u', 'v'));
        num2ChMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        for (int i = 0; i < digits.length(); i++) {
            List<String> tmpList = new ArrayList<>();
            int num = digits.charAt(i) - '0';
            if (num < 2 || num > 9) {
                continue;
            }
            List<Character> list = num2ChMap.get(num);
            for (Character ch : list) {
                if (resultList.size() == 0) {
                    tmpList.add(ch.toString());
                    continue;
                }

                for (String res : resultList) {
                    tmpList.add(res + ch);
                }
            }
            // 某个字符完事之后 更新 结果
            resultList = tmpList;
        }
        return resultList;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        String digits = "23";
        List<String> lists = solution.letterCombinations(digits);
        System.out.println(lists);
    }


}
