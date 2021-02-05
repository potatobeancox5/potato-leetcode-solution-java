package com.potato.study.leetcodecn.p01002.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

 你可以按任意顺序返回答案。

  

 示例 1：

 输入：["bella","label","roller"]
 输出：["e","l","l"]
 示例 2：

 输入：["cool","lock","cook"]
 输出：["c","o"]
  

 提示：

 1 <= A.length <= 100
 1 <= A[i].length <= 100
 A[i][j] 是小写字母

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-common-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1.遍历 arr 计算 每个 单词出现字母的次数
     * 2.对于每个字母 遍历统计矩阵， 找到最小值，
     * 3.将当前字母用最小值次数 写入 返回值
     * @param arr
     * @return
     */
    public List<String> commonChars(String[] arr) {
        List<String> result = new ArrayList<>();
        if (null == arr) {
            return result;
        }
        // 1.遍历 arr 计算 每个 单词出现字母的次数
        int[][] countMap = new int[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            countMap[i] = getCountMap(word);
        }
        // 2.对于每个字母 遍历统计矩阵， 找到最小值，
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < countMap.length; j++) {
                min = Math.min(min, countMap[j][i]);
            }
            // 找到之后 写入 res
            for (int j = 0; j < min; j++) {
                result.add("" + (char)(i + 'a'));
            }
        }
        return result;
    }

    /**
     * 遍历 word 每个字母 统计出现次数
     * @param word
     * @return
     */
    private int[] getCountMap(String word) {
        int[] countMap = new int[26];
        if (null == word) {
            return countMap;
        }
        for (char ch : word.toCharArray()) {
            countMap[ch - 'a']++;
        }
        return countMap;
    }


}
