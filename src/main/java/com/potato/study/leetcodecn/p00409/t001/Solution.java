package com.potato.study.leetcodecn.p00409.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

 注意:
 假设字符串的长度不会超过 1010。

 示例 1:

 输入:
 "abccccdd"

 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-palindrome
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计数，遍历计数器，记录是够有奇数节点，计算总长
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = countMap.getOrDefault(ch, 0);
            count++;
            countMap.put(ch, count);
        }
        // 遍历计数器，记录是够有奇数节点，计算总长
        boolean hasOdd = false;
        int num = 0;
        for (Integer count : countMap.values()) {
            if (count % 2 == 0) {
                num += count;
            } else {
                num += (count - 1);
                hasOdd = true;
            }
        }
        return hasOdd ? num + 1: num;
    }
}
