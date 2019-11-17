package com.potato.study.leetcode.p0522;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         522. Longest Uncommon Subsequence II
 * 
 *         Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc", "eae"
Output: 3
Note:

All the given strings' lengths will not exceed 10.
The length of the given list will be in the range of [2, 50].


 * 
 * 
 *         思路：
 *
 *         522. Longest Uncommon Subsequence II

https://blog.csdn.net/zsensei/article/details/75227927

依次判断每个字符串s 是不是其他串的子串

fori 0 len 控制判断子串
isUncommonsub true
for j 0len
if  不是子串
isUn fasel
break
end for
if 不是uncommon 求最大长度



子方法 a是否为b 的子串
if a比b 长 白扯
if 等于b 必须是
index 标记目前查看a的位置

for i 0 blen
如果 index 等于 alen break

如果a index 字符 等于b i字符
index++

return alen 是否等于 index


https://blog.csdn.net/zsensei/article/details/75227927
 *          
 */
public class Solution {

    public int findLUSlength(String[] strs) {
        int maxUncommonLength = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean isSub = true;

            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSub = false;
                    break;
                }
            }
            // 计算最大值
            if (isSub) {
                maxUncommonLength = Math.max(maxUncommonLength, strs[i].length());
            }
        }
        return maxUncommonLength;
    }

    /**
     * 判断 a是否是b的子序列
     * （a长度 小于b 长度）
     * @param a
     * @param b
     * @return
     */
    private boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }
        if (a.equals(b)) {
            return true;
        }
        // 记录当前找到 index位于 a的位置
        int index = 0;
        for (int i = 0; i < b.length(); i++) {
            if (index == a.length()) {
                break;
            }
            if (a.charAt(index) == b.charAt(i)) {
                index++;
            }
        }
        return index == a.length();
    }
	
	public static void main(String[] args) {

        Solution solution = new Solution();
        String[] words = {"aba", "cdc", "eae"};
        int max = solution.findLUSlength(words);
        System.out.println(max);
        Assert.assertEquals(3, max);

        String[] words1 = {"aaa","aaa","aa"};
        max = solution.findLUSlength(words1);
        System.out.println(max);
        Assert.assertEquals(-1, max);
    }
}
