package com.potato.study.leetcode.p1147;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1147. Longest Chunked Palindrome Decomposition
 *  
 *
 * Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:

Each a_i is a non-empty string;
Their concatenation a_1 + a_2 + ... + a_k is equal to text;
For all 1 <= i <= k,  a_i = a_{k+1 - i}.


Example 1:

Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
Example 2:

Input: text = "merchant"
Output: 1
Explanation: We can split the string on "(merchant)".
Example 3:

Input: text = "antaprezatepzapreanta"
Output: 11
Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
Example 4:

Input: text = "aaa"
Output: 3
Explanation: We can split the string on "(a)(a)(a)".


Constraints:

text consists only of lowercase English characters.
1 <= text.length <= 1000
 *         
 *
 *      题目含义：
 *          返回 将给定字符串分割成 回文字符串的 最大部分数 每一个小部分都是回文字符串
 *
 *      思路：
 *          https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition/solution/shuang-zhi-zhen-1msji-bai-9811-by-gskfid/
 *
 *
 *
 *
 */
public class Solution {

    public int longestDecomposition(String text) {

        int left = 0;
        int right = text.length() -1;
        // 遍历 字符串找到回文可能
        int ans = 0;
        int k = 0;
        // 初始位置
        int i0 = 0;
        int j0 = text.length() - 1;
        while (left < right) {
            while (left < right) {
                if (text.charAt(left++) == text.charAt(right)) {
                    break;
                }
            }
            k = left--;
            while (left >= i0) {
                if (text.charAt(right) != text.charAt(left)) {
                    break;
                }
                left--;
                right--;
            }
            if (left < i0) {
                ans += 2;
                i0 = k;
            } else {
                right = j0;
            }
            left = k;
            j0 = right;
        }
        ans = i0 > j0 ? ans : ans + 1;
        // 不满足回文情况下 整体是一个段
        return ans;
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int count = solution.longestDecomposition(text);
        System.out.println(count);
        Assert.assertEquals(7, count);

        text = "merchant";
        count = solution.longestDecomposition(text);
        System.out.println(count);
        Assert.assertEquals(1, count);
    }
}
