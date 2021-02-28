package com.potato.study.leetcodecn.p00131.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

 返回 s 所有可能的分割方案。

 示例:

 输入: "aab"
 输出:
 [
 ["aa","b"],
 ["a","a","b"]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 动态规划
     * dp i  【0 - i-1】 字符串都是回文字符
     * dp i =  从 i 往前 i-1， i-2 如果 子串是回文的 dp 结果集  add All dp i-1 中加上1
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        // dp 记录 达到每个状态可能的结果集合
        List<List<String>>[] dp = new List[s.length()];
        dp[0] = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(s.charAt(0)));
        dp[0].add(list);
        // 从 dp 1 开始找 一直找到 len - 1
        for (int i = 1; i < s.length(); i++) {
            dp[i] = new ArrayList<>();
            // 循环找sub string 判断 是不是回文
            for (int j = 0; j <= i; j++) {
                String word = s.substring(i - j, i + 1);
                if (!isPalindrome(word)) {
                    continue;
                }
                // 生成结果集合
                if (i == j) {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(word);
                    dp[i].add(tmp);
                } else {
                    dp[i].addAll(getPartition(word, dp[i-j-1]));
                }
            }
        }
        return dp[s.length()-1];
    }

    /**
     * 遍历  lists 生成 新的list 其中 每个 元素 增加word
     * @param word
     * @param lists
     * @return
     */
    private List<List<String>> getPartition(String word, List<List<String>> lists) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> eachList : lists) {
            List<String> newResult = new ArrayList<>(eachList);
            newResult.add(word);

            result.add(newResult);
        }
        return result;
    }


    /**
     * 判断 一个 word 是否 是回文 字符串
     * @param word
     * @return
     */
    private boolean isPalindrome(String word) {
        if (null == word || word.length() < 2) {
            return true;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left <= right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> partition = solution.partition(s);
        System.out.println(partition);
    }

}
