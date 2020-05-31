package com.potato.study.leetcode.p1156;


/**
 * 
 * @author liuzhao11
 * 
 * 	1156. Swap For Longest Repeated Character Substring
 *  
 *
 * Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.



Example 1:

Input: text = "ababa"
Output: 3
Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
Example 2:

Input: text = "aaabaaa"
Output: 6
Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa", which its length is 6.
Example 3:

Input: text = "aaabbaaa"
Output: 4
Example 4:

Input: text = "aaaaa"
Output: 5
Explanation: No need to swap, longest repeated character substring is "aaaaa", length is 5.
Example 5:

Input: text = "abcdef"
Output: 1


Constraints:

1 <= text.length <= 20000
text consist of lowercase English characters only.
 *         
 *
 *      题目含义：
 *          https://leetcode-cn.com/problems/swap-for-longest-repeated-character-substring/solution/java-tong-ji-ge-zi-mu-chu-xian-ci-shu-zai-shun-xu-/
 *
 *
 */
public class Solution {

    public int maxRepOpt1(String text) {
        int len = text.length();
        int[] ch_count = new int[26];
        //统计26个小写字母各自出现的次数
        for (int i = 0; i < len; ++i) {
            ++ch_count[text.charAt(i) - 'a'];
        }
        char last_ch = text.charAt(0);
        int count = 1, res = 1;
        for (int i = 1; i < len; ++i) {
            if (last_ch != text.charAt(i)) {
                int temp_idx = i;
                while (temp_idx + 1 < len && last_ch == text.charAt(temp_idx + 1)) {
                    ++count;
                    ++temp_idx;
                }
                if (ch_count[last_ch - 'a'] > count) {
                    ++count;
                }
                res = Math.max(res, count);
                count = 1;
                last_ch = text.charAt(i);
            } else {
                ++count;
            }
        }
        if (count > 1 && ch_count[last_ch - 'a'] > count) {
            ++count;
        }
        return Math.max(res, count);
    }
}
